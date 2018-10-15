package netmarble;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class netmable1 {
    public static String solution(String phrases, int second) {
        String answer = "";

        List<String> board = new LinkedList<>();
        List<String> resultBoard = new LinkedList<>();

        for (int i = 0; i < 14; i++) {
            board.add("_");
        }

        resultBoard = board.stream()
                .filter(a -> a.equals("_"))
                .collect(Collectors.toCollection(LinkedList::new));

        boolean isInsert = true;

        for (int i = 0; i < second; i++) {
            LinkedList<String> checkBoard = resultBoard.stream()
                                .filter(a -> a.equals("_"))
                                .collect(Collectors.toCollection(LinkedList::new));
            
            if(isEmpty(checkBoard) || isInsert == true) {
                insert((LinkedList)resultBoard,i,phrases);
                checkBoard = resultBoard.stream()
                        .filter(a -> a.equals("_"))
                        .collect(Collectors.toCollection(LinkedList::new));
                if(checkBoard.size() == 0 && i == phrases.length()){
                    isInsert = false;
                }
            } else{
                extract((LinkedList)resultBoard,i,phrases);
                checkBoard = resultBoard.stream()
                        .filter(a -> a.equals("_"))
                        .collect(Collectors.toCollection(LinkedList::new));
                if(isEmpty(checkBoard)){
                    isInsert = true;
                }
            }
        }
        return resultBoard.stream().map(Object::toString).collect(Collectors.joining(""));
    }

    private static void extract(LinkedList<String> resultBoard, int second, String phrases) {
        resultBoard.addLast("_");
        resultBoard.removeFirst();
    }

    private static void insert(LinkedList<String> resultBoard, int second, String phrases) {
        resultBoard.addLast(phrases.charAt(second)+"");
        resultBoard.removeFirst();
    }

    private static boolean isEmpty(LinkedList<String> resultBoard) {
        return resultBoard.size() == 14;
    }

    public static void main(String[] args) {
        System.out.println(solution("sibal", 15));
    }
}
