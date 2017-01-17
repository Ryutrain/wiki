public abstract class CommandFactory{
	public static AbstractCommand getCommand(RequestContext rc){
		AbstractCommand command=nu;;
		Properties prop=new Properties();
		
		try{
			prop.load(new FileInputStream("c:/j2ee4/commands.properties"));
			
			String name=prop.getProperty(rc.getCommandPath());
			
			Class c=Class.forName(name);
			
			command=(AbstractCommand)c.newInstance();
		}catch(FileNotFoundException e){
			throw new RuntimeException(e.getMessage(),e);
		}catch(IOException e){
			throw new RuntimeException(e.getMessage(),e);
		}catch(ClassNotFoundException e){
			throw new RuntimeException(e.getMessage(),e);
		}catch(InstantiationException e){
			throw new RuntimeException(e.getMessage(),e);
		}catch(IllegalAccessException e){
			throw new RuntimeException(e.getMessage(),e);
		}
		return command;
	}
}