import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        HashMap<String ,Integer> map = new HashMap<>();
        map.put("Alen",12);
        map.put("Pero",32);
        map.put("Monika",23);
        map.put("Danijel",43);

        System.out.println(map.get("Alen"));
        System.out.println(map);
        map.remove("Pero");
        System.out.println(map);

    }
}