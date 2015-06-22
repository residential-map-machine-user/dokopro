package DAOs;

import javax.servlet.http.HttpServletRequest;

import BaseClasses.BaseDAO;

public class GroupDAO extends BaseDAO {
	//グループの作成
	//グループの全権表示
	//グループの削除(削除フラグ)
	//グループの編集
	//グループの表示(selectByUserId)
	//メンバーの表示(selectByGroupId)
	public int addGroup(HttpServletRequest request){
		  int successNum = 0;
		  try{
		    String sampleName = request.getParameter("SAMPLE_NAME");
		    String sampleTitle = request.getParameter("SAMPLE_TITLE");
		    String sampleSchool = request.getParameter("SAMPLE_SCHOOL");
		    String sql = "INSERT INTO table_ (a,b,c) values(?,?,?);";
		    PreparedStatement prstmt = conn.prepareStatement(sql);
		    int ctn = 1;
		    prstmt.setString(ctn++,sampleName);
		    prstmt.setString(ctn++,sampleTitle);
		    prstmt.setString(ctn++,sampleSchool);
		    successNum = prstmt.executeUpdate();
		  }catch(SQLException e){
		    e.printStackTrace();
		  }
		  return successNum;
		}

		//セレクト系のメソッド
		public List<SampleBean> selectAllSample(HttpServletRequest request){
		  ResultSet rs = null;
		  List<SapmpleBean> sampleList  = new ArrayList<>();
		  try{
		    String sql = "SELECT * FROM table_;";
		    PreparedStatement prstmt = conn.prepareStatement(sql);
		    rs = prstmt.executeQuery();
		    while(rs.next()){
		      SampleBean sample = new SampleBean();
		      sample.setSampleName(rs.getString("sample_name"));
		      sample.setSampleAddress(rs.getString("sample_address"));
		      sample.setSampleNickName(rs.getString("sample_nickname"));
		      sampleList.add(sample);
		    }
		  }catch(SQLException e){
		    e.printStackTrace();
		    rerutn sampleList;
		  }
		  return sampleList;
		}

		//特定のIDに紐づくリストを取得
		public List<SampleBean> selectSampleBySampleId(HttpServletRequest request){
		  ResultSet rs = null;
		  List<SapmpleBean> sampleList  = new ArrayList<>();
		  try{
		    int sampleId = Integer.parseInt(request.getParameter("SAMPLE_ID"));
		    int cnt = 1;
		    String sql = "SELECT * FROM table_;";
		    PreparedStatement prstmt = conn.prepareStatement(sql);
		    prstmt.setInt(cnt++,sampleId);
		    rs = prstmt.executeQuery();
		    while(rs.next()){
		      SampleBean sample = new SampleBean();
		      sample.setSampleName(rs.getString("sample_name"));
		      sample.setSampleAddress(rs.getString("sample_address"));
		      sample.setSampleNickName(rs.getString("sample_nickname"));
		      sampleList.add(sample);
		    }
		  }catch(SQLException e){
		    e.printStackTrace();
		    return sampleList;
		  }
		  return sampleList;
		}

		削除系のメソッド(フラグ管理バージョン)
		public int deleteSample(HttpServletRequest request){
		  int successNum = 0;
		  try{
		    int deleteFlag = Integer.parseInt(request.getParameter("DELETE_FLAG"));
		    String sql = "UPDATE table_ SET delete_flag=? WHERE sample_id=?;"
		    PreparedStatement prstmt = conn.prepareStatement(sql);
		    int ctn = 1;
		    prstmt.setInt(ctn++, deleteFlag);
		    successNum = prstmt.executeUpdate();
		  }catch(SQLException e){
		    e.printStackTrace();
		    return successNum;
		  }
		  return successNum;
		}

		//編集系のメソッド(一括の編集)
		public int updateSample(HttpServletRequest request){
		  int successNum = 0;
		  try{
		    int sample_id = Integer.parseInt(request.getParameter("CATEGORY_ID"));
		    String sampleName = request.getParameter("SAMPLE_NAME");
		    String sampleAddress = request.getParameter("SAMPLE_ADDRESS");
		    String sampleNickname =request.getParameter("SAMPLE_NICKNAME");
		    String sql = "UPDATE table_ SET sample_name=?, sample_address=?, sample_nickname=? WHERE sample_id=?;";
		    PreparedStatement prstmt = conn.prepareStatement(sql);
		    int ctn = 1;
		    prstmt.setString(ctn++, sampleName);
		    prstmt.setString(ctn++, sampleAddress);
		    prstmt.setInt(ctn++, sampleNickname);
		    successNum = prstmt.executeUpdate();
		  }catch(SQLException e){
		    e.printStackTrace();
		    return successNum;
		  }
		  return successNum;
		}
}
