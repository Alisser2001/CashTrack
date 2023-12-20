package com.alidev.cashtrack.util;

public interface SQLSentences {
    String get_find_all_from_by_sentence();
    String get_create_account_sentence();
    String get_create_money_sentence();
    String get_create_user_sentence();
    String get_delete_entity_sentence();
    String get_delete_account_revenues_sentence();
    String get_delete_account_expenses_sentence();
    String get_delete_account_id_from_users_sentence();
    String get_update_value_sentence();
    String get_update_balance_remove_sentence();
    String get_update_balance_add_sentence();
    String get_all_from_by_sentence();
    String get_account_balance_sentence();
}
