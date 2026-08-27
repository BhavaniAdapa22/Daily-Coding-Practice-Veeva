class FindInvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {
        HashMap<String, List<Transaction>> hm = new HashMap<>();
        Set<Integer> invalid = new HashSet<>();
        for (int i = 0; i < transactions.length; i++) {
            String tran = transactions[i];
            String[] val = tran.split(",");
            String name = val[0];
            int time = Integer.parseInt(val[1]);
            int amount = Integer.parseInt(val[2]);
            String city = val[3];
            if (amount > 1000) {
                invalid.add(i);
            }
            if (!hm.containsKey(name)) {
                hm.put(name, new ArrayList<>());
            }
            List<Transaction> list = hm.get(name);
            for (Transaction t : list) {
                if (Math.abs(t.time - time) <= 60 && !t.city.equals(city)) {
                    invalid.add(i);
                    invalid.add(t.index);
                }
            }
            list.add(new Transaction(time, amount, city, i));
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < transactions.length; i++) {
            if (invalid.contains(i)) {
                res.add(transactions[i]);
            }
        }
        return res;
    }
}
class Transaction {
    int time;
    int amount;
    String city;
    int index;

    Transaction(int time, int amount, String city, int index) {
        this.time = time;
        this.amount = amount;
        this.city = city;
        this.index = index;
    }
}
