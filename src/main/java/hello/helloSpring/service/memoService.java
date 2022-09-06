package hello.helloSpring.service;


import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class memoService {
    static LocalDate startDate = LocalDate.parse("2022-08-13");
    static Map<LocalDate, String> plan = new LinkedHashMap<>();

    public static void plan() {

        for (int i = 0; i < 9; i++) {
            plan.put(startDate.plusDays(i), "");
        }

        Map<LocalDate, String> schedule = new LinkedHashMap<>();
        schedule.put(LocalDate.parse("2022-08-13"), "대타신청하기");
        schedule.put(LocalDate.parse("2022-08-14"), "대타신청하기");
        schedule.put(LocalDate.parse("2022-08-20"), "대타신청하기");
        schedule.put(LocalDate.parse("2022-08-21"), "대타신청하기");
        schedule.put(LocalDate.parse("2022-08-16"), "애들만나기");
        schedule.put(LocalDate.parse("2022-08-17"), "애들만나기");
        schedule.put(LocalDate.parse("2022-08-19"), "제주도 - 현조");
        schedule.put(LocalDate.parse("2022-08-20"), "제주도 - 현조");



        for (Map.Entry<LocalDate, String> entry : plan.entrySet()) {
            LocalDate key = entry.getKey();
            String value = entry.getValue();

            if (entry.getValue().equals("")) {
                System.out.println("비어있는 날짜 " + entry.getKey() + "(" + entry.getKey().getDayOfWeek() + ") - " + entry.getValue());
            } else {
                System.out.println("약속 : " + entry.getKey() + "(" + entry.getKey().getDayOfWeek() + ") - " + entry.getValue());
            }
        }

        /*
         * 대타 말씀드리기
         * 제주도 - 한라산
         * 제주도 - 현조(19,20)
         * 꼬치들
         * 태태
         * 아현
         * 공예
         *
         */


    }

    public static void main(String[] args) {
        plan();

    }
}
