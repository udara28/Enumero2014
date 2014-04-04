#include <iostream>
#include <fstream>
#include <string>
#include <vector>
using namespace std;
void encrypt(char* fileName,string key);
void decrypt(char* fileName,string key,bool guess);

int main(int argc,char* argv[]){
	if(argc < 2){
		cout << "Wrong input format for:\n\tCrack <operation> <file_name> <flag> <key>" << endl;
	}
	if(string(argv[1]) == "encrypt"){
		if(argc < 4){
			encrypt(argv[2],string("yup"));
		}else{
			encrypt(argv[2],argv[3]);
		}
	}else if(string(argv[1]) == "decrypt"){
		if(argc < 4){
			cout << "Secret key is required to decrypt!" << endl;
		}else{
			if(string(argv[3]) == "-guess"){
				decrypt(argv[2],string(argv[4]),true);
			}else{
				decrypt(argv[2],string(argv[3]),false);
			}
		}
	}else{
		cout << "Unknown operation. Operation should be either encrypt or decrypt! " << endl;
	}
}
void encrypt(char* fileName,string key){
	ifstream fin(fileName);
	string line;
	int a,i,j;
	char c[3];
	c[0] = key.at(0);	c[1]=key.at(1);	c[2]=key.at(2);
	vector<int> arr;
	if(fin.is_open()){
		j=0;
		while(getline(fin,line)){
			cout << line << endl;
			for(i=0;i<line.length();i++){
				arr.push_back(line.at(i)^c[j%3]);
				j++;
			}
		}
	}
	fin.close();
	ofstream fout(fileName);
	if(fout.is_open()){
		for(vector<int>::iterator it = arr.begin();it != arr.end();it++){
			fout << *it << ",";
		}
	}
	fout.close();
}
void decrypt(char* fileName,string key,bool guess){
	ifstream fin(fileName);
	string line;
	int a,i;
	char c[3];
	c[0] = key.at(0);	c[1]=key.at(1);	c[2]=key.at(2);
	vector<char> arr;
	if(fin.is_open()){
		i = 0;
		if(guess){
			cout << "<-------------------------wild guess------------------------>" << endl;
			while(fin >> a){
				cout << (char)(a^c[i%3]);
				if(fin.peek() == ','){
					fin.ignore();
				}
				i++;
			}
			cout << endl << "<----------------------------------------------------------->" << endl;
		}else{
			while(fin >> a){
				arr.push_back((char)(a^c[i%3]));
				if(fin.peek() == ','){
					fin.ignore();
				}
				i++;
			}
		}
	}
	fin.close();
	if(!guess){
		ofstream fout(fileName);
		if(fout.is_open()){
			for(vector<char>::iterator it = arr.begin();it != arr.end();it++){
				fout << *it;
			}
		}
	}
} 