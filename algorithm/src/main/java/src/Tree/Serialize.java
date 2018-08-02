package src.Tree;

public class Serialize {
    String Serialize(TreeNode root) {
        if (root == null) {
            return null;
        }


        StringBuffer stringBuffer = new StringBuffer();
        Serialize(root, stringBuffer);

        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < stringBuffer.length(); i++) {
            ans.append(stringBuffer.charAt(i));
            if (i != stringBuffer.length() - 1) {
                ans.append(',');
            }
        }
        return ans.toString();

    }

    void Serialize(TreeNode root, StringBuffer stringBuffer) {
        if (root == null) {
            stringBuffer.append('#');
            return;
        }
        stringBuffer.append(root.val);
        Serialize(root.left, stringBuffer);
        Serialize(root.right, stringBuffer);
    }

    int index = 0;

    TreeNode Deserialize(String str) {
        index = 0;
        String strArr[] = str.split(",");
        return buildTree(strArr);
    }

    TreeNode buildTree(String[] str) {
        if (str[index].equals('#')) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(str[index]));
        index++;
        root.left = buildTree(str);
        root.right = buildTree(str);
        return root;
    }
}
