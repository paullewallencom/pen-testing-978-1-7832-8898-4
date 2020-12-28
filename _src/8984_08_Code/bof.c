#include <stdio.h>
#include <stdlib.h>

void IShouldNeverBeCalled(){
	puts("I Should never be called");
	exit(0);
}

void vulnerable(char *arg){
	char buff[10];
	strcpy(buff,arg);
}

int main(int argc, char **argv){
	vulnerable(argv[1]);
	return(0);
}