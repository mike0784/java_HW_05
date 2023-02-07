import java.util.*;
import java.util.stream.Collectors;

public class Program1 {
    public static void main(String[] args)
    {
        HashMap<String, TelephoneList> TelMap = new HashMap<>();

        TelMap.put("Иван Иванов", new TelephoneList());
        TelMap.get("Иван Иванов").setTelephone("88001122333");

        TelMap.put("Иван Курицин", new TelephoneList());
        TelMap.get("Иван Курицин").setTelephone("88001662333");
        TelMap.get("Иван Курицин").setTelephone("88001112333");

        TelMap.put("Иван Незлобин", new TelephoneList());
        TelMap.get("Иван Незлобин").setTelephone("88001122432");

        TelMap.put("Сергей Потапов", new TelephoneList());
        TelMap.get("Сергей Потапов").setTelephone("88001112453");
        TelMap.get("Сергей Потапов").setTelephone("8800163214");

        TelMap.put("Сергей Курицин", new TelephoneList());
        TelMap.get("Сергей Курицин").setTelephone("8800142421");

        TelMap.put("Михаил Незлобин", new TelephoneList());
        TelMap.get("Михаил Незлобин").setTelephone("880012343");

        Scanner console = new Scanner(System.in);
        System.out.print("Введите имя для пойска: ");
        String nameFind = console.nextLine();
        Set<String> keys = TelMap.keySet();

        System.out.println(keys);

        int count = 0;
        for(Iterator<String> it = keys.iterator(); it.hasNext();)
        {
            String text = (String) it.next();
            if(text.toUpperCase().contains(nameFind.toUpperCase())) count++;
        }
        System.out.println("Имя " + nameFind + " встречается " + Integer.toString(count) + " раз");
        sort(TelMap);
    }

    public static void sort(HashMap<String, TelephoneList> map)
    {
        /*Сортировка*/
        List<Map.Entry<String, TelephoneList>> mapValues = new ArrayList<>(map.entrySet());
        Map<String, TelephoneList> sortedMap = map.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue().getCount()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));
        /*Вывод в консоль*/
        for (Map.Entry<String, TelephoneList> entry: sortedMap.entrySet())
        {
            String key = entry.getKey();
            Integer value = entry.getValue().getCount();

            System.out.println(key + "=" + value);
        }

    }
}
