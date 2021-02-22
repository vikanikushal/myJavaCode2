class boundType <T extends Number> {

    public void display() {
        System.out.println("This is a bounded type generics class.");
    }
}

class Main1 {
    public static void main(String[] args) {

        boundType<Integer> obj = new boundType<>();
    }
}