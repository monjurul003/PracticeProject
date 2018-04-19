package self.mik.interviewbit.microsoft;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TrieSolution {

    /*
     * Complete the contacts function below.
     */
    private class ContactNode {

        public Map<Character, ContactNode> children;
        public boolean isEndofWord;

        public ContactNode() {
            children = new HashMap<Character, ContactNode>();
            isEndofWord = false;
        }
    }

    private ContactNode root;

    private void insertContact(String contactName) {

        if (root == null) {
            root = new ContactNode();
        }
        ContactNode node = root;
        for (int i = 0; i < contactName.length(); i++) {
            char ch = contactName.charAt(i);
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new ContactNode());
            }
            node = node.children.get(ch);
        }
        node.isEndofWord = true;
    }

    private int countWord(ContactNode node) {
        int result = 0;

        if (node.isEndofWord) {
            result++;
        }

        for (Character key : node.children.keySet()) {
            result += countWord(node.children.get(key));
        }

        return result;
    }

    private int findPrefix(String contactName) {
        if (root == null)
            return 0;

        ContactNode node = root;
        int count = 0;
        for (int i = 0; i < contactName.length(); i++) {
            char ch = contactName.charAt(i);
            if (!node.children.containsKey(ch)) {
                return 0;
            }
            node = node.children.get(ch);
        }


        count = countWord(node);

        return count;
    }

    private int[] contacts(String[][] queries) {

        List<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0].equals("add")) {
                insertContact(queries[i][1]);
            }
            if (queries[i][0].equals("find")) {
                ans.add(findPrefix(queries[i][1]));
            }
        }
        int arrayFinal[] = new int[ans.size()];

        for (int i = 0; i < arrayFinal.length; i++) {
            arrayFinal[i] = ans.get(i);
        }

        return arrayFinal;
    }


    public void testTrie() {
        Scanner scanner = new Scanner(System.in);
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.println(result[resultItr]);
        }


    }
}

