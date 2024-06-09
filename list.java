class list {
    private Node start;

    public int search(String nameOrPhone) {
        int index = 0;
        Node temp = start;
        while (temp != null) {
            if (temp.contact.getName().equals(nameOrPhone)
                    || temp.contact.getMobile().equals(nameOrPhone)) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public void remove(int index) {
        if (index == 0) {
            start = start.next;
        } else {
            int count = 0;
            Node temp = start;
            while (count < index - 1) {
                count++;
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }

    public void add(Contact data) {
        Node n1 = new Node(data);
        if (start == null) {
            start = n1;
        } else {
            Node lastNode = start;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = n1;
        }
        System.out.println("add");
    }

    private boolean isEmpty() {
        return start == null;
    }

    public int size() {
        int count = 0;
        Node temp = start;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public Contact get(int index) {
        Node temp = start;
        int count = 0;
        while (count < index) {
            count++;
            temp = temp.next;
        }
        return temp.contact;
    }

    // ------------------UPDATE NAME------------------------
    public void updateName(int index, String name) {
        get(index).setName(name);
    }

    // ------------------UPDATE MOBILE------------------------
    public void updateMobile(int index, String mobile) {
        get(index).setMobile(mobile);
    }

    // ------------------UPDATE COMPANY------------------------
    public void updateCompany(int index, String company) {
        get(index).setCompany(company);
        ;
    }

    // ------------------UPDATE SALARY------------------------
    public void updateSalary(int index, int salary) {
        get(index).setSalary(index);
    }

    public void listAll() {
        System.out.println(
                "+-----------------------------------------------------------------------------------------------+");
        System.out.println("| Contact ID\t| Name\t\t|Phone Number\t| Company\t| Salary\t| Birthday\t|");
        System.out.println(
                "+-----------------------------------------------------------------------------------------------+");
        for (int i = 0; i < size(); i++) {
            System.out.printf("| %-14s| %-14s| %-14s| %-14s| %-14d| %-14s|\n", get(i).getId(), get(i).getName(),
                    get(i).getMobile(), get(i).getCompany(), get(i).getSalary(), get(i).getBirthday());
        }
        System.out.println(
                "+-----------------------------------------------------------------------------------------------+");
    }

    //////////////////////////////
    // ------sorting and swap
    ///////////////////////////////
    private void swap(Node n) {
        Contact temp = n.contact;
        n.contact = n.next.contact;
        n.next.contact = temp;
    }

    public void sortSalary() {
        for (int i = size(); i > 1; i--) {
            Node temp = start;
            boolean sorted = true;
            for (int j = 0; j < i - 1; j++) {
                if (temp.contact.getSalary() > temp.next.contact.getSalary()) {
                    sorted = false;
                    swap(temp);
                }
                temp = temp.next;
            }
            if (sorted) {
                break;
            }
        }
    }

    public void sortBirthday() {
        for (int i = size(); i > 1; i--) {
            Node temp = start;
            boolean sorted = true;
            for (int j = 0; j < i - 1; j++) {

                String temp1 = temp.contact.getBirthday().substring(0, 4)
                        + temp.contact.getBirthday().substring(5, 7)
                        + temp.contact.getBirthday().substring(8, 10);
                int x1 = Integer.parseInt(temp1);
                String temp2 = temp.next.contact.getBirthday().substring(0, 4)
                        + temp.next.contact.getBirthday().substring(5, 7)
                        + temp.next.contact.getBirthday().substring(8, 10);
                int x2 = Integer.parseInt(temp2);
                if (x1 > x2) {
                    sorted = false;
                    swap(temp);
                }
                temp = temp.next;
            }
            if (sorted) {
                break;
            }
        }
    }

    public void sortName() {
        for (int i = size(); i > 1; i--) {
            Node temp = start;
            boolean sorted = true;
            for (int j = 0; j < i - 1; j++) {
                String name1 = temp.contact.getName().toLowerCase();
                String name2 = temp.next.contact.getName().toLowerCase();
                if (name1.compareTo(name2) > 0) {
                    sorted = false;
                    swap(temp);
                }
                temp = temp.next;
            }
            if (sorted) {
                break;
            }
        }
    }
    //////////////////////////////
    // ----innerclass
    /////////////////////////////

    class Node {
        private Contact contact;
        private Node next;

        public Node(Contact data) {
            this.contact = data;
        }
    }

    public String generateID() {
        Node temp = start;
        int lastNo = 0;
        while (temp != null) {
            String lastId = temp.contact.getId();
            int x = Integer.parseInt(lastId.substring(1));
            if (lastNo <= x) {
                lastNo = x;
            }
            temp = temp.next;
        }
        return String.format("B%04d", lastNo + 1);
    }
}