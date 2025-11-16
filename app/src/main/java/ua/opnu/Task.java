package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            String first = list.get(i);
            String second = list.get(i + 1);

            // Видаляємо рядок з меншою довжиною; якщо довжина однакова, видаляємо перший.
            if (first.length() <= second.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
        }
    }

    public void stutter(List<String> list) {
        int originalSize = list.size(); // Зберігаємо початковий розмір списку
        for (int i = 0; i < originalSize; i++) {
            list.add(2 * i, list.get(2 * i)); // Додаємо кожен елемент двічі
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            // Міняємо місцями елементи i та i + 1
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    public void removeDuplicates(List<String> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
                i--; // Зменшуємо індекс, щоб перевірити поточний елемент після видалення
            }
        }    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++; // Пропускаємо рядок "****", щоб не обробити його повторно
            }
        }    }

    public boolean isPalindrome(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        // Копіюємо всі елементи з черги в стек та повертаємо в чергу, щоб зберегти її початковий стан
        for (int i = 0; i < size; i++) {
            int element = queue.remove();
            stack.push(element);
            queue.add(element);
        }

        // Перевіряємо, чи елементи збігаються у прямому та зворотному порядку
        boolean isPalindrome = true;
        for (int i = 0; i < size; i++) {
            int element = queue.remove();
            if (element != stack.pop()) {
                isPalindrome = false;
            }
            queue.add(element); // Відновлюємо початковий порядок елементів
        }

        return isPalindrome;
    }

    public  void reorder(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int current = queue.poll();
            if (current < 0) {
                stack.push(current);
            } else {
                queue.add(current);
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < size - stack.size(); i++) {
            queue.add(queue.poll());
        }
        while (!stack.isEmpty()) {
            stack.push(queue.poll());
        }

        for (int i = 0; i < queue.size(); i++){
            int temp = queue.peek();
            if(temp >= 0){
                queue.poll();
                queue.add(temp);
            }
        }
    }

    public void rearrange(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        // Зберігаємо непарні числа в стек, а парні — назад у чергу
        for (int i = 0; i < size; i++) {
            int num = queue.remove();
            if (num % 2 == 0) {
                queue.add(num);  // Додаємо парне число назад у чергу
            } else {
                stack.push(num); // Зберігаємо непарне число в стек
            }
        }

        // Повертаємо всі елементи з черги назад у чергу (парні числа)
        size = queue.size();
        for (int i = 0; i < size; i++) {
            queue.add(queue.remove());
        }

        // Додаємо непарні числа з початку стека (щоб зберегти початковий порядок непарних)
        while (!stack.isEmpty()) {
            queue.add(stack.removeLast());
        }
    }

    public int maxLength(Set<String> set) {
        int maxLength = 0;
        for (String str : set) {
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }
        return maxLength;
    }

    public void removeEvenLength(Set<String> set) {
        // Видаляємо рядки парної довжини
        set.removeIf(str -> str.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1); // Унікальні елементи з першого списку
        Set<Integer> set2 = new HashSet<>(list2); // Унікальні елементи з другого списку
        set1.retainAll(set2); // Залишаємо тільки ті, що є в обох множинах
        return set1.size(); // Повертаємо кількість спільних елементів
    }

    public boolean isUnique(Map<String, String> map) {
        Set<String> uniqueValues = new HashSet<>();
        for (String value : map.values()) {
            if (!uniqueValues.add(value)) { // Якщо значення вже є в множині, повертаємо false
                return false;
            }
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();

        for (String key : map1.keySet()) {
            if (map2.containsKey(key) && map1.get(key).equals(map2.get(key))) {
                result.put(key, map1.get(key)); // Додаємо пару лише якщо ключ і значення однакові в обох мапах
            }
        }

        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> reversedMap = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            reversedMap.put(entry.getValue(), entry.getKey()); // Ключ і значення міняються місцями
        }
        return reversedMap;
    }

    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) return 0;

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int value : map.values()) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1); // Обчислюємо частоту кожного значення
        }

        int minFrequency = Integer.MAX_VALUE;
        int rarestValue = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int value = entry.getKey();
            int frequency = entry.getValue();

            if (frequency < minFrequency || (frequency == minFrequency && value < rarestValue)) {
                minFrequency = frequency;
                rarestValue = value; // Оновлюємо рідкісне значення, якщо знаходиться менша частота або менше значення з такою ж частотою
            }
        }

        return rarestValue;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) return 0;

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : list) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1); // Підраховуємо частоти чисел у списку
        }

        int maxOccurrences = 0;
        for (int frequency : frequencyMap.values()) {
            if (frequency > maxOccurrences) {
                maxOccurrences = frequency; // Знаходимо максимальну частоту
            }
        }

        return maxOccurrences;
    }
}
