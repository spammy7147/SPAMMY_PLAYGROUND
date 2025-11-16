
class Program
{
    enum ClassType
    {
        None = 0,
        Knight = 1,
        Archer = 2,
        Mage = 3,
    }
    
    enum MonsterType
    {
        Slime = 0,
        Orc = 1,
        Skeleton = 2,
        Mage = 3,
    }

    struct Player
    {
        public int hp;
        public int attack;
        public ClassType type;
    }

    struct Monster
    {
        public int hp;
        public int attack;
    }
    
    static ClassType ChooseClass()
    {
        Console.WriteLine("직업을 선택하세요!");
        Console.WriteLine("[1] 기사");
        Console.WriteLine("[2] 궁수");
        Console.WriteLine("[3] 법사");

        String input = Console.ReadLine();
        switch (input)
        {
            case "1": return ClassType.Knight;
            case "2": return ClassType.Archer;
            case "3": return ClassType.Mage;
            default: return ClassType.None;
        }
    }

    static void CreatePlayer(ClassType choice, out Player player)
    {
        switch (choice)
        {
            case ClassType.Knight:
                player.hp = 100;
                player.attack = 10;
                player.type = choice;
                break;
            case ClassType.Archer:
                player.hp = 75;
                player.attack = 7;
                player.type = choice;
                break;
            case ClassType.Mage:
                player.hp = 50;
                player.attack = 15;
                player.type = choice;
                break;
            default:
                player.hp = 0;
                player.attack = 0;
                player.type = choice;
                break;
        }
    }

    static void CreateRandomMonster(out Monster monster)
    {
        Random rand = new Random();
        int randMonster = rand.Next(1, 4);
        switch (randMonster)
        {
            case (int)MonsterType.Slime:
                Console.WriteLine("슬라임이 스폰되었습니다!");
                monster.hp = 20;
                monster.attack = 2;
                break;
            case (int)MonsterType.Orc:
                Console.WriteLine("오크가 스폰되었습니다!");
                monster.hp = 40;
                monster.attack = 4;
                break;
            case (int)MonsterType.Skeleton:
                Console.WriteLine("스켈레톤이 스폰되었습니다!");
                monster.hp = 30;
                monster.attack = 3;
                break;
            default:        
                monster.hp = 0;
                monster.attack = 0;
                break;
        }
        
    }

    static void Fight(ref Player player, ref Monster monsters)
    {
        while (true)
        {
            //플레이어가 몬스터 공격
            monsters.hp -= player.attack;
            if (monsters.hp <= 0)
            {
                Console.WriteLine("승리했습니다!");
                Console.WriteLine($"남은 체력: {player.hp}");
                break;
            }
            
            //몬스터 반격
            player.hp -= monsters.attack;
            if(player.hp <= 0)
            {
                Console.WriteLine("패배했습니다!");
                break;
            }
        }
    }
    static void EnterField(ref Player player)
    {
        while (true)
        {
            Console.WriteLine("필드에 접속했습니다!");

            Monster monster;
            CreateRandomMonster(out monster);
            // 랜덤으로 1~3 몬스터 중 하나를 리스폰

            Console.WriteLine("[1] 전투모드로 돌입");
            Console.WriteLine("[2] 일정 확률로 마을로 도망");
            // [1] 전투모드로 돌입
            // [2] 일정 확률로 마을로 도망

            String input = Console.ReadLine();
            switch (input)
            {
                case "1":
                    Fight(ref player, ref monster);
                    break;
                case "2":
                    Random rand = new Random();
                    int randValue = rand.Next(0, 101);
                    if (randValue <= 33)
                    {
                        Console.WriteLine("도망치는데 성공했습니다!");
                        return;
                    }
                    else
                    {
                        Fight(ref player, ref monster);
                        break;
                    }
            }
        }
    }
    
    static void EnterGame(ref Player player)
    {
        while (true)
        {
            Console.WriteLine("마을에 접속했습니다!");
            Console.WriteLine("[1] 필드로 간다");
            Console.WriteLine(("[2] 로비로 돌아가기"));

            String input = Console.ReadLine();
            switch (input)
            {
                case "1" :
                    EnterField(ref player);
                    break;
                case "2":
                    return;
            }
        }
        
    }
    
    static void Main(String[] args)
    {
        while (true)
        {
            ClassType choice = ChooseClass();
            if (choice == ClassType.None)  continue;
               
            //캐릭터 생성
            Player player;
            CreatePlayer(choice, out player);
            EnterGame(ref player);
                
        }
    }
}
