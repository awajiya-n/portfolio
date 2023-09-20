package model.bo;

import dao.AccountDAO;
import model.entity.Account;
import model.entity.Login;

public class LoginCheckLogic {
	public Account execute(Login login) {
		//アカウント情報取得のためのDAO呼び出し
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByLogin(login);

		// AccountDAQでのデータ取得結果によるCheckResult付与処理
		// アカウント情報が取得できなかったときは0を付与
		if(account == null) {
			account = new Account();
			account.setCheckResult(0);

		// AdminFlgが0（一般ユーザー）であった場合は1を付与
		} else if(account.getAdminFlg() == 0) {
			account.setCheckResult(1);

		// AdminFlgが1（管理者）であった場合は2を付与
		} else if(account.getAdminFlg() == 1) {
			account.setCheckResult(2);
		}
		return account;
	}

}
