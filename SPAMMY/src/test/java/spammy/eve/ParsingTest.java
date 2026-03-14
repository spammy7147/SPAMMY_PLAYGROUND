package spammy.eve;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestConstructor;
import spammy.eve.domain.*;
import spammy.eve.repository.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import static org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ParsingTest {

    private final BlueprintRepository bluePrintRepository;
    private final CategoryRepository categoryRepository;
    private final GroupRepository groupRepository;
    private final TypeRepository typeRepository;
    private final BlueprintItemRepository blueprintItemRepository;

    ParsingTest(BlueprintRepository bluePrintRepository, CategoryRepository categoryRepository,
                GroupRepository groupRepository, TypeRepository typeRepository, BlueprintItemRepository blueprintItemRepository) {
        this.bluePrintRepository = bluePrintRepository;
        this.categoryRepository = categoryRepository;
        this.groupRepository = groupRepository;
        this.typeRepository = typeRepository;
        this.blueprintItemRepository = blueprintItemRepository;
    }

    @Test
    @Rollback(false)
    @Order(1)
    void parseCategories() throws Exception {
        ObjectMapper om = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("static/categories.jsonl");

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                JsonNode root = om.readTree(line);

                Category category = Category.builder()
                        .id(root.path("_key").asLong())
                        .iconId(root.path("iconID").asLong())
                        .nameEn(root.path("name").path("en").asText())
                        .nameKo(root.path("name").path("ko").asText())
                        .published(root.path("published").asBoolean())
                        .build();

                categoryRepository.save(category);
            }
        }
    }

    @Test
    @Rollback(false)
    @Order(2)
    void parseGroups() throws Exception {
        ObjectMapper om = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("static/groups.jsonl");

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                JsonNode root = om.readTree(line);

                Group group = Group.builder()
                        .id(root.path("_key").asLong())
                        .category(categoryRepository.findById(root.path("categoryID").asLong()).orElse(null))
                        .nameEn(root.path("name").path("en").asText())
                        .nameKo(root.path("name").path("ko").asText())
                        .build();

                groupRepository.save(group);
            }
        }
    }


    @Test
    @Rollback(false)
    @Order(3)
    void parseTypes() throws Exception {
        ObjectMapper om = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("static/types.jsonl");

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                JsonNode root = om.readTree(line);

                Type type = Type.builder()
                        .id(root.path("_key").asLong())
                        .group(groupRepository.findById(root.path("groupID").asLong()).orElse(null))
                        .nameEn(root.path("name").path("en").asText())
                        .nameKo(root.path("name").path("ko").asText())
                        .published(root.path("published").asBoolean())
                        .build();


                typeRepository.save(type);
            }
        }
    }



    @Test
    @Rollback(false)
    @Order(4)
    void parseBlueprints() throws Exception {
        ObjectMapper om = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("static/blueprints.jsonl");

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                JsonNode root = om.readTree(line);
                Long id = root.path("_key").asLong();
                Integer limit = root.has("maxProductionLimit") ? root.path("maxProductionLimit").asInt() : null;
                Iterator<String> activities = root.path("activities").fieldNames();
                while (activities.hasNext()) {
                    String activityName = activities.next();
                    ActivityType activityType =  ActivityType.valueOf(activityName.toUpperCase());
                    JsonNode activity = root.path("activities").path(activityName);
                    Integer time = activity.has("time") ? activity.path("time").asInt() : null;
                    Blueprint blueprint = Blueprint.builder()
                            .blueprintTypeId(id)
                            .activityType(activityType)
                            .timeSeconds(time)
                            .maxProductionLimit(limit)
                            .items(new java.util.ArrayList<>())
                            .build();

                    boolean flag = false;
                    for (JsonNode material : activity.path("materials")) {
                        if (typeRepository.findById(material.path("typeID").asLong()).orElse(null) == null) {
                            flag = true;
                            break;
                        }
                        BlueprintItem blueprintItem = BlueprintItem.builder()
                                .blueprint(blueprint)
                                .kind(BlueprintItemKind.MATERIAL)
                                .type(typeRepository.findById(material.path("typeID").asLong()).orElse(null))
                                .qty(material.path("quantity").asLong())
                                .probability(material.path("probability").asDouble())
                                .consumed(true)
                                .build();
                        blueprint.addItem(blueprintItem);
                    }

                    for (JsonNode product : activity.path("products")) {
                        if (typeRepository.findById(product.path("typeID").asLong()).orElse(null) == null) {
                            flag = true;
                            break;
                        }
                        BlueprintItem blueprintItem = BlueprintItem.builder()
                                .blueprint(blueprint)
                                .kind(BlueprintItemKind.PRODUCT)
                                .type(typeRepository.findById(product.path("typeID").asLong()).orElse(null))
                                .qty(product.path("quantity").asLong())
                                .probability(product.path("probability").asDouble())
                                .consumed(false)
                                .build();
                        blueprint.addItem(blueprintItem);
                    }
                    if (flag) continue;
                    bluePrintRepository.save(blueprint);
                }
            }
        }
    }
}