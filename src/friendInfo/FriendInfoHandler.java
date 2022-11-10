package friendInfo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import commonUtil.CommonUtil;
import main.ICustomDefine;

// 기능을 담당하는 클래스를 핸들러 혹은 매니져 클래스라고 한다.
public class FriendInfoHandler {

    ArrayList<Friend> lists;

    public FriendInfoHandler() {
        lists = new ArrayList<Friend>();
    }

    // 친구 정보 추가를 위한 멤버메서드
    void addFriend(int choice) {

        // 친구의 기본정보를 먼저 입력받는다.
        String iName, iPhone, iAddr, iNickname, iMajor;// inputName, inputPhone, ...
        iName = CommonUtil.scanValue("이름");
        iPhone = CommonUtil.scanValue("전화번호");
        iAddr = CommonUtil.scanValue("주소");

        // 입력 선택에 따라 고딩 혹은 대딩으로 분기하여 입력받는다.
        if (choice == ICustomDefine.ADD_HIGH_FRIEND) {
            // 고딩을 선택한 경우
            iNickname = CommonUtil.scanValue("별명");
            // 객체를 생성하여 참조변수에 저장한다.
            HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname);
            // 참조값을 객체배열에 추가한다.
            lists.add(high);
        } else if (choice == ICustomDefine.ADD_UNIV_FRIEND) {
            // 대딩을 선택한 경우
            iMajor = CommonUtil.scanValue("전공");
            // 객체생성과 동시에 참조값을 객체 배열에 추가한다.
            UnivFriend univ = new UnivFriend(iName, iPhone, iAddr, iMajor);
            lists.add(univ);
        } else {
            System.out.println("비정상적인 입력입니다.");
        }
        /*
         * 더이상 실행할 문장이 없다면, 해당 메서드는 메모리에서 소멸되고
         * 호출한 지점으로 돌아가게 된다.
         */
        System.out.println("친구정보 입력이 완료되었습니다.");
        // scan.close();
    }

    // 전체정보 조회 메서드
    void showAllData() {
        // 향상된 for문으로 변경해봄.
        for (Friend f : lists) {
            f.showAllData();
        }
        System.out.println("===전체 정보가 출력되었습니다.===");
    }

    // 간략정보 조회메서드
    void showSimpleData() {
        // Iterator 로 변경해봄.
        Iterator<Friend> itr = lists.iterator();
        while (itr.hasNext()) {
            Friend f = itr.next();
            f.showBasicInfo();
        }
        System.out.println("===간략 정보가 출력되었습니다.===");
    }

    // 친구정보찾기 : 주소록 검색
    void searchInfo() {
        // 검색한 정보가 존재하는지 확인하기 위한 변수
        boolean isFind = false;
        String searchName = CommonUtil.scanValue("검색할 이름");
        for (int i = 0; i < lists.size(); i++) {
            if (searchName.compareTo(lists.get(i).getName()) == 0) {
                lists.get(i).showAllData();
                System.out.println("** 귀하가 요청하는 정보를 찾았습니다. **");
                isFind = true;
            }
        }
        // 만약 검색된 정보가 없다면 아래와 같이 출력한다.
        if (isFind == false) {
            System.out.println("***찾는 정보가 없습니다.***");
        }
    }

    // 친구정보 수정
    void modifyInfo() {

        /*
         * 1. 수정할 친구 이름 입력받기
         * 2. 수정할 친구가 주소록에 있는지 검색
         * 3. 수정할 주소 / 전화번호 / 별명 / 전공 입력받기
         * 4. 변경하지 않으려면 그냥 skip
         * 5. 정보 수정하기
         */

        String tmpName = CommonUtil.scanValue("친구이름");

        int tempNum = 0;
        for (Friend f : lists) {
            if (tmpName.equals(f.getName())) {
                String tmpAddr = CommonUtil.scanValue("주소");
                if (!tmpAddr.isEmpty()) {
                    f.setAddr(tmpAddr);
                }
                String tmpPhone = CommonUtil.scanValue("전화번호");
                if (!tmpPhone.isEmpty()) {
                    f.setPhone(tmpPhone);
                }
                String tmpStr = CommonUtil.scanValue("별명 / 전공");
                if (!tmpStr.isEmpty()) {
                    if (f instanceof HighFriend) {
                        ((HighFriend) f).setNickname(tmpStr);
                    } else if (f instanceof UnivFriend) {
                        ((UnivFriend) f).setMajor(tmpStr);
                    }
                }
            } else {
                System.out.println("검색하려는 친구의 정보가 없습니다.");
            }
        }
        if (tempNum > 0) {
            System.out.println("=======수정완료========");
        }


    }

    // 친구정보 삭제 : 주소록 삭제
    void deleteInfo() {

        String deleteName = CommonUtil.scanValue("삭제할 이름");
        int count = 0;
        // 저장된 정보의 크기만큼 반복하여 삭제할 객체를 찾는다.
        for (int i = 0; i < lists.size(); i++) {
            // 입력된 이름과 같은지 비교
            if (deleteName.compareTo(lists.get(i).getName()) == 0) {
                lists.remove(i);
                System.out.println("주소록에서 삭제했습니다.");
                count++;
                // 하나의 객체를 삭제했다면 즉시 for문을 탈출한다.
                break;
            }
        }
        if (0 == count) {
            System.out.println("삭제할 친구를 찾지 못했습니다.");
        }
    }

    // 저장하기
    void saveFriendInfo() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/saveFile/FriendInfo.obj"));

            for (Friend a : lists) {
                // 파일에 저장한다 , 즉 직렬화한다.
                out.writeObject(a);
            }
            // out.writeObject(accHashSet);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("친구 정보가 저장되었습니다.");
    }


    // 불러오기
    void loadFriendInfo() {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("src/saveFile/FriendInfo.obj"));

            while (true) {
                lists.add((Friend) in.readObject());
                // stuHs.add((Student)ois.readObject());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("파일 끝");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("친구 정보가 복원되었습니다.");
    }



}


