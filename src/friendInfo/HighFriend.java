package friendInfo;

/*
 * 고등학교 친구 정보를 저장할 클래스
 */
public class HighFriend extends Friend {
    // 자식에서 확장한 멤버변수 : 별명
    private String nickname;
    
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    // 인수생성자
    public HighFriend(String name, String phone, String addr, String nickname) {
        /*
         * 자식객체는 부모객체를 초기화할 수 있는 인수까지 모두 받은후
         * super()를 통해 부모생성자를 먼저 호출한다
         */
        super(name, phone, addr);
        this.nickname = nickname;
    }

    @Override
    public void showAllData() {
        System.out.println("===고딩친구(전체정보)===");
        super.showAllData();
        System.out.printf("별명 : %s%n",this.nickname);
    }

    @Override
    public void showBasicInfo() {
        System.out.println("===고딩친구(간단정보)===");
        System.out.printf("별명 : %s \t 전화번호 : %s%n",this.nickname,super.getPhone());
        System.out.println("==========================");
    }

}
