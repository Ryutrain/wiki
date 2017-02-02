package wiki;

import java.util.ArrayList;
import wiki.WikiPage;
import fw.DBManager;

import java.sql.ResultSet;

public abstract class Executer{
	DBManager accessor = new DBManager();
	
	public abstract Object execute(Object object);
}