import java.io.File;
import javax.swing.JOptionPane;

public class Code implements Runnable {

        public static final String file_name="abc.txt";
	private String path ="";
        private int A1=-1;
        private String [][]arrayArray= new String[512][512];
	private static String[] pathArray = new String[100];
	private  String[] treeArray;

	private File file;

	public Code(String pa) {
		path += pa;
	}

	public  void pathArray(String path) {
                this.path="";
		for (int i = 0; i <= pathArray.length; i++) {
			if (pathArray[i] == null) {
				pathArray[i] =  path;
                                 System.out.println("\n"+pathArray[i]+"\n");

				break;
			}
		}
		for (int i=0; i<= pathArray.length;i++) {
			if(pathArray[i]!=null){
                            if(path !="/"){
                        this.path +=("/"+pathArray[i]);
                            }
                            else{
                                this.path+=path;
                            }
                        }
                        else{
                            break;
                        }
                }

		pathMethod(this.path);
	}

	private void pathMethod(String path) {
		file = new File(path);

		if (file.isDirectory()) {
			tree(file);
		} else {
                    decreasingArray();

		}
	}

	private void tree(File file) {
                    ++A1;
		    arrayArray[A1] = file.list();

               System.out.println("Path :"+path);

		System.out.println("NAME--> "+file.getName());



                try{
		if (arrayArray[A1].length==0) {
                	decreasingArray();

                        deA1();


		}
                else {
                        for(String s : arrayArray[A1]){
                             if(s=="abc"){
                               
                                 System.out.println("Code.tree()");
                                }
                          System.out.println(s);
                           }
                        int i=0;
                        while(i<arrayArray[A1].length){


				if((i+1)==arrayArray[A1].length){
                                  pathArray(arrayArray[A1][i]);
                                    deA1();

                                    decreasingArray();

                                    break;
                                }
                                else{
                                    pathArray(arrayArray[A1][i]);
                                    i++;
                                    }
                    }
                }

                }catch(NullPointerException e){}

                  System.out.println("Finish");
	}


	private void decreasingArray() {

		for (int i = 0; i < pathArray.length; i++) {
			if (pathArray[i]==null) {
				pathArray[i - 1] = null;
                                break;
                        }
		}
        }

	private void deA1(){
        A1--;
        }
    @Override
    public void run() {
       	pathArray(path);
            JOptionPane.showMessageDialog(null, "FINISH");

    }
}
