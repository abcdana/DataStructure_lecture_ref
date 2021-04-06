package list.arraylist.implementation;

public class Main {

	public static void main(String[] args) {
	
		//ArrayList.java������ class�� �ν��Ͻ�ȭ ��Ŵ
		ArrayList numbers = new ArrayList();
		
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		
		numbers.add(1, 15);
		
		numbers.addFirst(5);
		
		
		numbers.remove(1);

		System.out.println("numbers.indexOf(20) : " + numbers.indexOf(20));
		
		System.out.println("numbers : " + numbers);
		System.out.println("numbers.size() : " + numbers.size());
		
		
//		for (int i=0; i<numbers.size(); i++) {
//			System.out.println(numbers.get(i));
//		}
		
		
		ArrayList.ListIterator li = numbers.listIterator();

		while(li.hasNext()) {
			System.out.println("li.next() : " + li.next());
		}
		
		
		while(li.hasPrevious()) {
			System.out.println("li.previous() : " + li.previous());
		}
		
		
		while(li.hasNext()) {
			
			int number = (int)li.next();
		
			if (number == 30) {
				li.add(35);
			}
			
			if (number == 15) {
				li.remove();
			}
		}
		
		System.out.println("numbers : " + numbers);
		
	}
	
}
