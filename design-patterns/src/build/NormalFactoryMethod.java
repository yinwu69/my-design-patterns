package build;

public class NormalFactoryMethod {
	public static void main(String[] args) {
		SaasFactory factory = new SaasFactory();
		SaaS saas = factory.saasProduce(WinhongSaaS.class.getSimpleName());
		saas.saasService("saas service!");
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