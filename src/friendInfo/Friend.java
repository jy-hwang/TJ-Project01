package friendInfo;

import java.io.Serializable;

abstract public class Friend implements Serializable {

    // 멤버변수 : 이름, 전화번호, 주소 기본정보 3가지를 표현
    private String name;
    private String phone;
    private String addr;

    //getter & setter
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    // 인수생성자 : 멤버변수 초기화
    public Friend(String name, String phone, String addr) {
        this.name = name;
        this.phone = phone;
        this.addr = addr;
    }

    // 멤버메서드 : 멤버변수 전체를 출력하기 위한 메서드
    public void showAllData() {
        System.out.printf("이름 : %s\t 전화번호 : %s\t 주소 : %s\t ",name,phone,addr);
    }
    /*
     * 간략한 정보를 출력하기 위한 메서드로 실행부가 없는 상태로 정의한다.
     * 해당 프로그램에서는 오버라이딩의 목적으로만 사용하기 위해 정의한다.
     */

    public void showBasicInfo() {
        // overriding 해서 쓰시오.
    }
}
