import java.util.Scanner;

public class Operation {

	Scanner scan = new Scanner(System.in);

	public Student[] studentlist = new Student[400];
	String sid;
	String sname;
	String surname;
	int scount = 0;

	public Course[] courselist = new Course[40];
	String cid;
	String cname;
	int credit;
	int quota;
	int ccount = 0;

	public Specified[] speclist = new Specified[3200];
	int speccount = 0;

	public void addstudent() {

		System.out.print("Enter student ID:");
		sid = scan.next();
		if (scount != 0) {
			for (int i = 0; i < scount; i++) {
				if (studentlist[i].getSid().equals(sid)) {
					System.out
							.println("Error: This student has already been added");
					addstudent();
				}
			}
		}
		System.out.print("Enter Name:");
		sname = scan.next();

		System.out.print("Enter Surname:");
		surname = scan.next();

		Student student = new Student();

		student.setSid(sid);
		student.setSname(sname);
		student.setSsurname(surname);

		studentlist[scount] = student;

		scount++;
		System.out.print("Done!\n");

	}

	public void addspecified() {

		System.out.print("Enter student ID:");
		sid = scan.next();

		System.out.print("Enter courset ID:");
		cid = scan.next();

		if (scount != 0) {
			for (int i = 0; i < scount; i++) {
				if (studentlist[i].getSid().equals(sid)) {
					if (ccount != 0) {
						for (int j = 0; j < ccount; j++) {
							if (courselist[j].getCid().equals(cid)) {
								System.out
										.println("Error: This student has already been added to this course");
								addspecified();
							}
						}
					}
				}
			}
		}
		Specified spec = new Specified();

		spec.setSid(sid);
		spec.setCid(cid);

		speclist[speccount] = spec;

		speccount++;
		System.out.print("Done!\n");
	}

	public void addcourse() {

		System.out.print("Enter course ID:");
		cid = scan.next();
		if (ccount != 0) {
			for (int i = 0; i < ccount; i++) {
				if (courselist[i].getCid().equals(cid)) {
					System.out
							.println("Error: This course has already been added");
					addcourse();
				}
			}
		}
		System.out.print("Enter Name:");
		cname = scan.next();

		System.out.print("Enter Credit:");
		credit = scan.nextInt();
		
		System.out.print("Enter Quota:");
		quota = scan.nextInt();

		Course course = new Course();

		course.setCid(cid);
		course.setCname(cname);
		course.setCredit(credit);
		course.setQuota(quota);

		courselist[ccount] = course;
		ccount++;
		System.out.print("Done!\n");
	}

	public void deleteStud() {
		System.out.print("Enter student ID:");
		sid = scan.next();

		if (scount != 0) {
			for (int i = 0; i < scount; i++) {
				if (!studentlist[i].getSid().equals(sid)) {
					System.out.println("Error: This student ID does not exist");
					deleteStud();
				}
			}
		}
		for (int i = 0; i < scount; i++) {
			if (studentlist[i].getSid().equals(sid)) {
				for (int j = 0; j < scount - 1; j++) {
					studentlist[j] = studentlist[j + 1];
					studentlist[j + 1] = null;
				}
				scount--;
				System.out.println("Done!");
			}
		}
	}

	public void deleteSpec() {

		System.out.print("Enter student ID:");
		sid = scan.next();
		System.out.print("Enter course ID:");
		cid = scan.next();
		if (scount != 0) {
			for (int i = 0; i < scount; i++) {
				if (!studentlist[i].getSid().equals(sid)) { 
					if (ccount != 0) {
						for (int j = 0; j < ccount; j++) {
							if (courselist[j].getCid().equals(cid) || !courselist[j].getCid().equals(cid)) {
								System.out
										.println("Error: This student does not exist in this course");
							}
						}
					}
				}
			}
			for (int i = 0; i < scount; i++) {
				if (studentlist[i].getSid().equals(sid)) {
					if (ccount != 0) {
						for (int j = 0; j < ccount; j++) {
							if (!courselist[j].getCid().equals(cid)) {
								System.out
										.println("Error: This student has not taken this course");
							}
						}
						deleteSpec();
					}
				}
			}
		}
		for (int i = 0; i < scount; i++) {
			if (speclist[i].getSid().equals(sid)
					&& speclist[i].getCid().equals(cid)) {
				for (int j = 0; j < speccount - 1; j++) {
					speclist[j] = speclist[j + 1];
					speclist[j + 1] = null;
				}
				speccount--;
				System.out.println("Done!");
			}
		}
	}

	public void deleteCo() {
		System.out.print("Enter course ID:");
		cid = scan.next();
		if (ccount != 0) {
			for (int j = 0; j < ccount; j++) {
				if (!courselist[j].getCid().equals(cid)) {
					System.out
							.println("Error: This course does not exist");
				}
			}
		}
		for (int i = 0; i < ccount; i++) {
			if (courselist[i].getCid().equals(cid)) {
				for (int j = 0; j < ccount - 1; j++) {
					courselist[j] = courselist[j + 1];
					courselist[j + 1] = null;
				}
				ccount--;
				System.out.println("Done!");
			}
		}
	}

	public void listSpecCrs() {
		System.out.print("Enter course ID:");
		cid = scan.next();
		if (ccount==0){
			System.out.println("There are no courses recorded yet. Please add courses before listing.");
		}
		for (int i = 0; i < ccount; i++) {
			if (courselist[i].getCid().equals(cid)) {
				System.out.print(courselist[i].getCid() + "  "
						+ courselist[i].getCname() + "  "
						+ courselist[i].getCredit() + "  "
						+ courselist[i].getQuota() + "\n");
			}
		}
		for (int j = 0; j < speccount; j++) {
			if (speclist[j].getCid().equals(cid)) {
				for (int k = 0; k < scount; k++) {
					if (studentlist[k].getSid().equals(speclist[j].getSid())) {
						System.out.print(studentlist[k].getSid() + "  "
								+ studentlist[k].getSname() + "  "
								+ studentlist[k].getSsurname() + "\n");
					}
				}
			}
		}
	}

	public void listSpecStd() {
		System.out.print("Enter student ID:");
		sid = scan.next();
		if (scount==0){
			System.out.println("There are no students recorded yet. Please add students before listing.");
		}
		for (int i = 0; i < scount; i++) {
			if (studentlist[i].getSid().equals(sid)) {
				System.out.print(studentlist[i].getSid() + "  "
						+ studentlist[i].getSname() + "  "
						+ studentlist[i].getSsurname() + "\n");
			}
			else if (!studentlist[i].getSid().equals(sid)) {
				System.out.print("This student ID does not exist");
			}
		}
		for (int j = 0; j < speccount; j++) {
			if (speclist[j].getSid().equals(sid)) {
				for (int k = 0; k < scount; k++) {
					if (courselist[k].getCid().equals(speclist[j].getCid())) {
						System.out.print(courselist[k].getCid() + "  "
								+ courselist[k].getCname() + "  "
								+ courselist[k].getCredit() + "  "
								+ courselist[k].getQuota() + "\n");
					}
				}
			}
		}
	}

	public void listStud() {
		
		if(scount==0){
			System.out.println("There are no students to list. Please add student(s)");
		}
		for (int i = 0; i < scount; i++) {
			System.out.print(studentlist[i].getSid() + "  "
					+ studentlist[i].getSname() + "  "
					+ studentlist[i].getSsurname() + "\n");

		}
	}

	public void listCourse() {
		
		if(ccount==0){
			System.out.println("There are no courses to list. Please add course(s)");
		}
		for (int i = 0; i < ccount; i++) {
			System.out.print(courselist[i].getCid() + "  "
					+ courselist[i].getCname() + "  "
					+ courselist[i].getCredit() + "  "
					+ courselist[i].getQuota() + "\n");

		}
	}
}