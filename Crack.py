import sys

def encrypt(fileName,keyword):
	fin = open(fileName,'r')
	s = fin.read()
	arr = []
	for i in xrange(0,len(s)):
		arr.append(ord(s[i])^ord(keyword[i%3]))
	fin.close()
	fout = open(fileName,'w');
	for j in arr:
		fout.write(str(j)+",");
	return
	
def decrypt(fileName,keyword,guess):
	if guess:
		fin = open(fileName,'r')
		s = fin.read()
		arr = s.split(',')
		print "<-----------------------wild guess------------------------>"
		for i in xrange(0,len(arr)-1):
			sys.stdout.write(chr(int(arr[i])^ord(keyword[i%3]))),
		print "\n<--------------------------------------------------------->"
		fin.close()
	else:
		fin = open(fileName,'r')
		s = fin.read()
		arr = s.split(',')
		out = ""
		for i in xrange(0,len(arr)-1):
			out += chr(int(arr[i])^ord(keyword[i%3]))
		fin.close()
		fout = open(fileName,'w')
		fout.write(out);
		fout.close()
	return
	
if __name__=='__main__':
	if sys.argv[1] == "encrypt":
		if len(sys.argv) < 3 :
			encrypt(sys.argv[2],"yup")
		else:
			encrypt(sys.argv[2],sys.argv[3])
	elif sys.argv[1] == "decrypt":
		if(len(sys.argv)<5):
			decrypt(sys.argv[2],sys.argv[3],False)
		elif(sys.argv[3] == "-guess"):
			decrypt(sys.argv[2],sys.argv[4],True)