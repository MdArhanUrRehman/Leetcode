
class ProductOfNumbers {

    ArrayList<Integer> prefix_list;

    public ProductOfNumbers() {
        prefix_list = new ArrayList<>();
        prefix_list.add(1);
    }

    public void add(int num) {

        if (num == 0) {
            prefix_list.clear();
            prefix_list.add(1);
        } else {
            int last = prefix_list.get(prefix_list.size() - 1);
            prefix_list.add(last * num);
        }
    }

    public int getProduct(int k) {

        int n = prefix_list.size();

        if (k >= n) {
            return 0;
        }

        return prefix_list.get(n - 1) / prefix_list.get(n - k - 1);
    }
}


/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */