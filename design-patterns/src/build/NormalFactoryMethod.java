package build;


public class NormalFactoryMethod {
	public static void main(String[] args) {
		/**
		test
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


interface SaaS {
	public void saasService(String arg);
}

class WinhongSaaS implements SaaS {
	@Override
	public void saasService(String arg) {
		System.out.println("winhong CNware:" + arg);
	}
}

class HaweiSaaS implements SaaS{
	@Override
	public void saasService(String arg) {
		System.out.println("Hawei Saas:" + arg);
	}
}

class AliYun implements SaaS{
	@Override
	public void saasService(String arg) {
		System.out.println("Ali yun:" + arg);
	}
}

class SaasFactory {
	public SaaS saasProduce(String saas) {
		if(saas.equals("WinhongSaaS")) {
			return new WinhongSaaS();
		} else if (saas.equals("HaiweiSaaS")) {
			return new HaweiSaaS();
		} else {
			return null;
		}
	}
}

class SaasFactoryEx {
	public SaaS produceWinhongSaas() {
		return new WinhongSaaS();
	}
	
	public SaaS produceHaweiSaas() {
		return new HaweiSaaS();
	}
}

class SaasFacory4Static {
	public static SaaS produceWinhongSaas() {
		return new WinhongSaaS();
	}
	
	public static SaaS produceHaweiSaas() {
		return new HaweiSaaS();
	}
	
	public static SaaS produceAliYun() {
		return new AliYun();
	}
}
