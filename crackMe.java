import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

/**
 *
 * @author udara
 */
class Crack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        if(args.length > 0){
            if(args[0].equals("encrypt")){
		if(args.length < 3){
			encrypt(args[1]);
		}else{
                	encrypt(args[1],args[2]);
		}            
            }else if(args[0].equals("decrypt")){
		if(args.length < 3){
			System.out.println("You have forgotten to give me the key!");
		}else if(args.length == 3){
                	decrypt(args[1],args[2],false);
		}else if(args.length == 4){
			if(args[2].equals("-guess")){
				decrypt(args[1],args[3],true);
			}
		}
            }else if(args[0].equals("hack")){
		System.out.println("Not support in this version!\n");
	    }
        }
    }
    public static void encrypt(String fileName) throws IOException{
      //  BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String nextLine;
        String content = "";
        while((nextLine = br.readLine()) != null){
            content += nextLine + "\n";
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        char c[] = content.toCharArray();
        char k[] = {'y','u','p'};
        int i=0;
        for(char j : c){
            bw.write((int) (j^k[i%k.length])+",");
            i++;
        }
        bw.close();
    }

    public static void encrypt(String fileName,String key) throws IOException{
      //  BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String nextLine;
        String content = "";
        while((nextLine = br.readLine()) != null){
            content += nextLine + "\n";
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        char c[] = content.toCharArray();
        char k[] = new char[3];
	k[0] = key.charAt(0);
	k[1] = key.charAt(1);
	k[2] = key.charAt(2);
        int i=0;
        for(char j : c){
            bw.write((int) (j^k[i%k.length])+",");
            i++;
        }
        bw.close();
    }
    public static void decrypt(String fileName,String key,boolean guess) throws FileNotFoundException, IOException{
	BufferedReader br = new BufferedReader(new FileReader(fileName));
	String line = br.readLine();
	StringTokenizer st = new StringTokenizer(line,",");
	br.close();
	int i = 0;
	char c[] = new char[st.countTokens()];
	while(st.hasMoreTokens()){
		c[i] = (char) (Integer.parseInt(st.nextToken())^key.charAt(i%3));
		i++;
	}
	String data = String.copyValueOf(c);
	if(!guess){
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		bw.write(data);
		bw.close();
	}else{
		System.out.println("<-----------------------Wild guess--------------------------->");
		System.out.println(data);
		System.out.println("<------------------------------------------------------------>");
	}
    }
}
