package friendInfo;

//대학교 친구 정보를 저장하기 위한 클래스

public class UnivFriend extends Friend {
    // 확장한 멤버변수로 전공과목을 표현
    String major;

    // 생성자와 멤버메서드 모두 HighFriend클래스와 동일하게 정의됨.
    public UnivFriend(String name, String phone, String addr, String major) {
        super(name, phone, addr);
        this.major = major;
    }

    @Override
    public void showAllData() {
        System.out.println("===대학친구(전체정보)===");
        super.showAllData();
        System.out.println("전공 : " + major);
    }

    @Override
    public void showBasicInfo() {
        System.out.println("==대학친구==");
        System.out.println("전공 : " + major);
        System.out.println("전화번호 : " + phone);
    }
}
