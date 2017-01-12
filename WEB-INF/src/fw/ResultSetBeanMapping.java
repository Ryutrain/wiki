package fw;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetBeanMapping<T>{
	public Object createFromResultSet(ResultSet rs)
		throws SQLException;
}
	