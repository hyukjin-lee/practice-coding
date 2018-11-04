package algorithm.ka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ka1 {
    static String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

    public static void main(String[] args) {
        System.out.println(solution(record));
    }

    public static String[] solution(String[] record) {
        Map<String, String> uidNickNameMap = new HashMap<>();
        String[] splitString;
        List<String> answer = new ArrayList<>();
        String[] realAnswer = new String[answer.size()];

        for (int i = 0; i < record.length; i++) {
            splitString = record[i].split(" ");
            if (splitString[0].equals("Enter")) {
                uidNickNameMap.put(splitString[1], splitString[2]);
                continue;
            }
            if (splitString[0].equals("Change")) {
                uidNickNameMap.put(splitString[1], splitString[2]);
                continue;
            }
        }

        for (int i = 0; i < record.length; i++) {
            splitString = record[i].split(" ");
            if (!splitString[0].equals("Change"))
                if (splitString[0].equals("Enter")) {
                    answer.add(uidNickNameMap.get(splitString[1]) + "님이 들어왔습니다.");
                } else if (splitString[0].equals("Leave")) {
                    answer.add(uidNickNameMap.get(splitString[1]) + "님이 나갔습니다.");
                }
        }
        return answer.toArray(realAnswer);
    }
}
