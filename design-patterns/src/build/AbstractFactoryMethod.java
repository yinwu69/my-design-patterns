package build;


public class AbstractFactoryMethod {
	public static void main(String[] args) {
		/**
		 * 普通工厂模式
		 * 建立一个工厂类，对实现了同一接口的一些类进行实例的创建。
		 */
		SaasFactory factory = new SaasFactory();
		SaaS saas = factory.saasProduce(WinhongSaaS.class.getSimpleName());
		saas.saasService("saas service!");
		
		/**
		 * 多个工厂方法模式
		 * 对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，
		 * 则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象
		 */
		SaasFactoryEx saasFactory = new SaasFactoryEx();
		SaaS huaweiSaas = saasFactory.produceHaweiSaas();
		huaweiSaas.saasService("huawei service");
		
		/**
		 * 将多个工厂方法模式里的方法置为静态的，不需要创建实例
		 */
		SaaS aliYun = SaasFacory4Static.produceAliYun();
		aliYun.saasService("aliYun service...");
	}
}


