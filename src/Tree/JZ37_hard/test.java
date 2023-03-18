package Tree.JZ37_hard;

public class test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(1 + ",");
        sb.append(2 + ",");
        sb.append(3 );
        sb.append("]");
        System.out.println(sb);
        String[] vals = sb.toString().substring(1,sb.length()-1).split(",");
        System.out.println(Integer.parseInt(vals[0]));
    }
}
