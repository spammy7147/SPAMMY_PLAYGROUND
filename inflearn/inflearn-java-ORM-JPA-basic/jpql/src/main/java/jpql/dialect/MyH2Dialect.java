package jpql.dialect;

import org.hibernate.boot.model.FunctionContributions;
import org.hibernate.boot.model.FunctionContributor;
import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class MyH2Dialect extends H2Dialect {


    /**
     * 사용자함수 hibernate 6버전부터 변경되어 해당 내용 사용 불가
     */
    public MyH2Dialect() {
//        registerFunction("group_concat", new StandardSQLFunction("group_concat"), StandardBasicTypes.STRING);


    }

    /**
     * 해당클래스를 생성하여
     * src/main/resources/META-INF/services/org.hibernate.boot.model.FunctionContributor 파일생성
     * 해당 파일 안에 생성한 클래스를 패키지 포함하여 작성한다
     * dialect를 변경안해도 적용
     */
    public class CustomFunctionContributor implements FunctionContributor {
        @Override
        public void contributeFunctions(FunctionContributions functionContributions) {
            functionContributions.getFunctionRegistry()
                    .register("group_concat", new StandardSQLFunction("group_concat", StandardBasicTypes.STRING));
        }
    }

}
