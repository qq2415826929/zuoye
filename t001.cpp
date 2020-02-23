#include<stdio.h>
int inputInt(int low,int high,char des[30])
{
	int temp,flag=0;
   	flag=scanf("%d",&temp);
	while(flag==0||temp>high||temp<low){
		printf(" 输入%s,必须输入数字且必须大于等于%d,小于等于%d\n",des,low,high);
		fflush(stdin);
		flag=scanf("%d",&temp);
	}
    return temp;
}
void triangle1()
{
	int tempa,thickness,i,j;
	int flag=0;
	printf("请输入直角等腰三角形的底长(大小限制2-120):");
	tempa=inputInt(2,120,"直角等腰三角形的底长");

    printf("请输入直角等腰三角形的厚度(大小限制1-%d):",tempa);
	thickness=inputInt(1,tempa,"直角等腰三角形的厚度");
		for(i=1;i<=tempa;i++)
		{
			if(i<=thickness)
		{
			for(j=1;j<=thickness;j++) 
				printf("#");
		}
		else if(i>tempa-thickness){
			for(j=1;j<=i;j++)
				printf("#");
		}
		else{
			for(j=1;j<=i;j++)
			{
				if(j<thickness+1)
					printf("#");
				else if(j>i-thickness)
					printf("#");
				else
					printf(" ");
			}
		}
		printf("\n");	
	}
}
main()
{
  triangle1();
  return 0;
}