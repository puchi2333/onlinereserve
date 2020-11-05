class Singleton{
public:
static Singleton& getInstance(){
static Singleton instance;
return instance;
}
void printTest(){
cout<<"do something"<<endl;
}
private:
Singleton(){}//��ֹ�ⲿ���ù��촴������
Singleton(Singleton const &singleton);//��ֹ������������
Singleton& operator=(Singleton const &singleton);//��ֹ��ֵ����
};
int main()
{
Singleton &a=Singleton::getInstance();
a.printTest();
return 0;
}

���ȣ����캯��������private��Ŀ����ֻ�����ڲ����ã�getInstance()�еľ�̬�ֲ���������ʱ���ã����������ⲿ���ù��촴���ڶ���ʵ����
Ȼ�󣬿�������Ϳ�����ֵ������������private�����������壬��Ŀ������ֹ�����������ͼͨ�����������������ڶ���ʵ�����������ᱨ��

��ֹ��������һ��д�����������һ��"=delete",Ҳ������ͬ�����ã�C++11����



2.����ģʽ
����ģʽ�������֣��򵥹���ģʽ����������ģʽ�����󹤳�ģʽ��

����ģʽ����Ҫ�����Ƿ�װ����Ĵ������������Ĵ����Ͳ������̣����������������Ĵ������̣����ڳ����ά������չ��

��1���򵥹���ģʽ

�򵥹����ǹ���ģʽ��򵥵�һ��ʵ�֣����ڲ�ͬ��Ʒ�Ĵ�������һ�������࣬����Ʒ��������Ϊ�������뵽�����Ĵ����������������ͷ�֧ѡ��ͬ�Ĳ�Ʒ���캯����

//�򵥹���ģʽ
typedef enum ProductTypeTag
{
TypeA,
TypeB,
TypeC
}PRODUCTTYPE;
class Product//��Ʒ�������
{
public:
virtual void Show() = 0;
};
class ProductA : public Product
{
public:
void Show()
{
cout<<"I'm ProductA"<<endl;
}
};
class ProductB : public Product
{
public:
void Show()
{
cout<<"I'm ProductB"<<endl;
}
};
class ProductC : public Product
{
public:
void Show()
{
cout<<"I'm ProductC"<<endl;
}
};
class Factory//������
{
public:
Product* CreateProduct(PRODUCTTYPE type)
{
switch (type)
{
case TypeA:
return new ProductA();
case TypeB:
return new ProductB();
case TypeC:
return new ProductC();
default:
return NULL;
}
}
};
int main()
{
Factory productCreator;
Product *productA=productCreator.CreateProduct(TypeA);
Product *productB=productCreator.CreateProduct(TypeB);
Product *productC=productCreator.CreateProduct(TypeC);
productA->Show();
productB->Show();
productC->Show();
if(productA){
delete productA;
productA=NULL;
}
if(productB){
delete productB;
productB=NULL;
}
if(productC){
delete productC;
productC=NULL;
}
return 0;
}

��2����������ģʽ
��ʵ��������ڵĹ���ģʽ���򵥹���ģʽֻ��һ���򵥵ĶԴ������̷�װ����������ģʽ�ڼ򵥹���ģʽ�Ļ��������ӶԹ����Ļ�����󣬲�ͬ�Ĳ�Ʒ�������ò�ͬ�Ĺ����������ӹ����ĳ������������������������ͬ�Ĳ�Ʒ���̾��ɲ�ͬ�Ĺ����ֹ������FactoryAר�ĸ�������ProductA��FactoryBר�ĸ�������ProductB��FactoryA��FactoryB֮��û�й�ϵ��������˺��ڣ������Ҫ����ProductCʱ����������Դ���һ��FactoryC�����࣬����ר�ĸ�������ProductC���Ʒ��

��ģʽ����ڼ򵥹���ģʽ���������ڣ����ں��ڲ�Ʒ�������չ��

//��������ģʽ
typedef enum ProductTypeTag
{
TypeA,
TypeB,
TypeC
}PRODUCTTYPE;
class Product//��Ʒ�������
{
public:
virtual void Show() = 0;
};
class ProductA : public Product
{
public:
void Show()
{
cout<<"I'm ProductA"<<endl;
}
};
class ProductB : public Product
{
public:
void Show()
{
cout<<"I'm ProductB"<<endl;
}
};
class Factory//������
{
public:
virtual Product *createProduct()=0;
};
class FactoryA:public Factory{
public:
Product *createProduct(){
return new ProductA();
}
};
class FactoryB:public Factory{
public:
Product *createProduct(){
return new ProductB();
}
};
class FactoryC:public Factory{
public:
Product *createProduct(){
return new ProductC();
}
};
int main()
{
Factory *factoryA=new FactoryA();
Product *productA = factoryA->createProduct();
productA->Show();
Factory *factoryB=new FactoryB();
Product *productB = factoryB->createProduct();
productB->Show();
if (factoryA)
{
delete factoryA;
factoryA = NULL;
}
if (factoryB)
{
delete factoryB;
factoryB = NULL;
}
if (productA)
{
delete productA;
productA = NULL;
}
if (productB)
{
delete productB;
productB = NULL;
}
return 0;
}

��3�����󹤳�ģʽ

���󹤳�ģʽ�Թ�������ģʽ�����˸���һ�㻯����������������ģʽ�����ڲ�Ʒ����ṹ��һ�ĳ��ϣ�Ϊһ���Ʒ�ṩ�����Ľӿڣ������󹤳����������ڲ�Ʒ����ṹ��ĳ��ϣ����ǵ����ж�������Ʒ����ʱ�����󹤳�����������ó���

���󹤳�ģʽ���ʺ�ʵ������������������ޣ��õͶ˹���������ͬ����ĵͶ˲�Ʒ���߶˹���������ͬ����ĸ߶˲�Ʒ��

//���󹤳�ģʽ
class ProductA
{
public:
virtual void Show() = 0;
};
class ProductA1 : public ProductA//A��Ͷ˲�Ʒ
{
public:
void Show()
{
cout<<"I'm ProductA1"<<endl;
}
};
class ProductA2 : public ProductA//A��߶˲�Ʒ
{
public:
void Show()
{
cout<<"I'm ProductA2"<<endl;
}
};
class ProductB
{
public:
virtual void Show() = 0;
};
class ProductB1 : public ProductB//B��Ͷ˲�Ʒ
{
public:
void Show()
{
cout<<"I'm ProductB1"<<endl;
}
};
class ProductB2 : public ProductB//B��߶˲�Ʒ
{
public:
void Show()
{
cout<<"I'm ProductB2"<<endl;
}
};
class Factory
{
public:
virtual ProductA *CreateProductA() = 0;
virtual ProductB *CreateProductB() = 0;
};
class Factory1 : public Factory//1�Ź������������Ͷ˲�Ʒ
{
public:
ProductA *CreateProductA()
{
return new ProductA1();
}
ProductB *CreateProductB()
{
return new ProductB1();
}
};
class Factory2 : public Factory//2�Ź������������߶˲�Ʒ
{
ProductA *CreateProductA()
{
return new ProductA2();
}
ProductB *CreateProductB()
{
return new ProductB2();
}
};
int main()
{
Factory *factory1 = new Factory1();
ProductA *productA1 = factory1->CreateProductA();
ProductB *productB1 = factory1->CreateProductB();
productA1->Show();
productB1->Show();
Factory *factory2 = new Factory2();
ProductA *productA2 = factory2->CreateProductA();
ProductB *productB2 = factory2->CreateProductB();
productA2->Show();
productB2->Show();
if (factory1)
{
delete factory1;
factory1 = NULL;
}
if (productA1)
{
delete productA1;
productA1= NULL;
}
if (productB1)
{
delete productB1;
productB1 = NULL;
}
if (factory2)
{
delete factory2;
factory2 = NULL;
}
if (productA2)
{
delete productA2;
productA2 = NULL;
}
if (productB2)
{
delete productB2;
productB2 = NULL;
}
}
3 ����ģʽ
ת����https://blog.csdn.net/lh844386434/article/details/16825861

����ģʽҲ��һ�ַǳ����õ����ģʽ������Ҳ�����ӡ��������Ǿ�����������ģʽ��

���壺����ģʽ������һϵ�е��㷨������ÿһ���㷨��װ����������ʹ���ǻ������໥�滻������ģʽ���㷨������ʹ�����Ŀͻ��������仯��

��ɫ��
    ������Խ�ɫ��Strategy���� ��������ࡣ
    ������Խ�ɫ(ConcreteStrategy)����װ�˼�����ص��㷨����Ϊ��
    ������ɫ(Context)������һ������������ã����ո��ͻ��˵��á�

UMLͼ��

                

������ ���������ı���һ���������ģʽ�����⣩

     ����������һ�����ʦ�����������һ�ֿյ����������ǵĿյ�Ҫ֧��3��ģʽ�����ģʽ��ColdWind��, �ȷ�ģʽ(WramWind)���޷�ģʽ��NoWind����
��ѡ��ColdWindģʽ����������磻��ѡ��WarmWindģʽ���������ȷ磻��ѡ��NoWindģʽʱ���յ�ʲô���������㽫�������Ϊ�յ����Ӧ�ó�����������յ���Ҫ����֧���µ�ģʽ�أ�

��������⣬��ʵ�����ø���ģʽʵ�֣�Ȼ����������������ģʽ�ȽϺ��ʡ����ǽ����ģʽ�����ȷ�ģʽ�Լ��޷�ģʽ�������Ϊ���ֲ�ͬ���㷨����Ȼ����ģʽ�ǳ����ϡ�

����ColdWind, WramWind, NoWind ��ʵ����ConcreteStrategy�� IWnd �ǳ�������ࡣ �������ǿ�ʼ��ô��װ���ǲ�����

#include <iostream>
using namespace std;
#define  free_ptr(p) \
	if(p) delete p; p = NULL;
 
class IWind{
public:
	virtual ~IWind(){};
	virtual void blowWind() = 0;
};
 
class ColdWind : public IWind{
public:
	void blowWind(){
		cout<<"Blowing cold wind!"<<endl;
	};
};
 
class WarmWind : public IWind{
public:
	void blowWind(){
		cout<<"Blowing warm wind!"<<endl;
	}
};
 
class NoWind : public IWind{
public:
	void blowWind(){
		cout<<"No Wind!"<<endl;
	}
};
Ȼ������ʵ��һ��windmode ���࣬��Ϊ wind ϵ�еĻ����ࣺ

class WindMode{
public:
	WindMode(IWind* wind): m_wind(wind){};
	~WindMode(){free_ptr(m_wind);}
	void blowWind(){
		m_wind->blowWind();
	};
private:
	IWind* m_wind;
};
���ͻ��˴��룺

int main(int argc, char* argv[])
{
	WindMode* warmWind = new WindMode(new WarmWind());
	WindMode* coldWind = new WindMode(new ColdWind());
	WindMode* noWind = new WindMode(new NoWind());
 
	warmWind->BlowWind();
	coldWind->BlowWind();
	noWind->BlowWind();
 
	free_ptr(warmWind);
	free_ptr(coldWind);
	free_ptr(noWind);
	system("pause");
	return 0;
}
�����ʵ������Ҳ����������ģʽʵ�֡�����ģʽ�뿴�Һ���Ĳ��͡�����磬�ȷ磬�޷���Ϊһ�������Ȼ��������һ��˼·��Ҳδ�����ɡ������Ҿ��������������ģʽ����ĸ�������Ӧ���ӣ�����ϵ�е������ࣩ����ɶ���Ŀ����������һ����ģʽ��ʱ������Ҫ��ӵ�����ࡣ�����ٲ�����ô���ǡ������Ҹ�����Ϊ���������ģʽ����һЩ����
�ܵ�˵������ģʽ��

�ŵ㣺
1�� ʹ�ò���ģʽ���Ա���ʹ�ö�������ת����䡣����ת����䲻��ά����
2�� ����ģʽ������Զ�̬�ĸı�������Ϊ����̬�޸Ĳ���

ȱ�㣺
1���ͻ��˱���֪�����еĲ����࣬�����о���ʹ����һ�������ࡣ
2�������---����ģʽ��ɺܶ�Ĳ����࣬ÿ����������඼�����һ�����ࡣ��������ͨ����Ԫģʽ���˷�����ࣩ

ģʽ���壺
        ����ģʽ�������󡱷�װ�ɶ����Ա�ʹ�ò�ͬ�����󡢶��л�����־��������������������ģʽҲ֧�ֿɳ����Ĳ�����

        ������󽫶����ͽ����߰��������У��������ֻ��¶һ��execute()������

        ����Ҫ����������Ķ����ִ������Ķ�������ʱ��ʹ������ģʽ��

ģʽ�ṹ��


������
        ң��������һ����ۣ����Է��ϲ�ͬ��װ�ã�Ȼ���ð�ť���ơ�����������õ�ƣ����п��͹ذ�ť����������ģʽʵ�֡�

UML��ƣ�

        ���У�RemoteControlΪң������LightOnCommandΪ�����������LightOffCommandΪ�ص�����������Ǽ̳��Ի���Command��������ƿ���ʹ������Ժ��ֹ������װ�á�

#include <iostream>
 
using namespace std;
 
//�����
class Light
{
public:
	void on()
	{
		cout << "Light on !" << endl;
	}
 
	void off()
	{
		cout << "Light off !" << endl;
	}
};
//������
class Command
{
public:
	virtual void execute(){}
};
//����������
class LigthOnCommand : public Command
{
public:
	LigthOnCommand(Light* lig):light(lig){}
	//execute����
	void execute()
	{
		light->on();
	}
private:
	Light* light;
};
 
class LigthOffCommand : public Command
{
public:
	LigthOffCommand(Light* lig):light(lig){}
	void execute()
	{
		light->off();
	}
private:
	Light* light;
};
 
//ң������
class RemoteControl
{
public:
	void setCommand(Command* command)
	{
		slot = command;
	}
	void buttonOn()
	{
		slot->execute();
	}
private:
	Command* slot;
};
//�ͻ�����
int main()
{
	RemoteControl lightOnControl;
	RemoteControl lightOffControl;
 
	Command* onCommand = new LigthOnCommand(new Light());
	Command* offCommand = new LigthOffCommand(new Light());
 
	lightOnControl.setCommand(onCommand);
	lightOffControl.setCommand(offCommand);
 
	lightOnControl.buttonOn();
	lightOffControl.buttonOn();
 
	return 0;
}


