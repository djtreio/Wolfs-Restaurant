SQLite format 3   @     �   	                                                            � .;�% 
� |*y��G
�                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            �,	�+tableBookingsBookings	CREATE TABLE Bookings (id INTEGER PRIMARY KEY AUTOINCREMENT, size INTEGER, time TEXT, name TEXT, date TEXT, notes TEXT, email TEXT, phone TEXT)�D�ctableTablesTablesCREATE TABLE Tables (T1 INTEGER, T2 INTEGER, T3 INTEGER, T4 INTEGER, T5 INTEGER, T6 INTEGER, T7 INTEGER, T8 INTEGER, T9 INTEGER, T10 INTEGER, T11 INTEGER, T12 INTEGER, id)�#�tableEmployeesEmployeesCREATE TABLE Employees (id INTEGER PRIMARY KEY AUTOINCREMENT, name STRING, role STRING, email STRING, position STRING, phone STRING)o##�%tableCredentialsCredentialsCREATE TABLE Credentials (employeeid INTEGER PRIMARY KEY, credential STRING)   ��gtableEmployeesEmployeesCREATE TABLE Employees (id INTEGER PRIMARY KEY AUTOINCREMENT, firstName STRING, lastName STRING, role	     �B�gtableMenuMenuCREATE TABLE Menu (id INTEGER PRIMARY KEY AUTOINCREMENT, name STRING, category STRING, price DOUBLE, status CHAR DEFAULT y CHECK (status = "y" OR status = "n"), cost DOUBLE)�.�;tableItemsItemsCREATE TABLE Items (id INTEGER PRIMARY KEY AUTOINCREMENT, orderid INTEGER, name TEXT, side TEXT, allergy TEXT, discount FLOAT, notes TEXT, price FLOAT)P++Ytablesqlite_sequencesqlite_sequenceCREATE TABLE sqlite_sequence(name,seq)��]tableOrdersOrdersCREATE TABLE Orders(id INTEGER PRIMARY KEY AUTOINCREMENT, price FLOAT, discount FLOAT, finalprice FLOAT)� � ����eM'�F����wX9����`A"����hI*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              " @7�    @(�\    @%�     ! @?c�    @-L��   @0�p�     @%Ǯ    @G�    @�@    @9��   @1��@   @ ff�    @0�   @�   @%\@    @HL��   @3h��   @=0��    @9���   @`   @6��    @J��   @0\)    @B`      @A��@   @      @@��@    @H�f`   @�\    @E�z�    @M\)    @*.�   @FУ�    @.�z�   @"#�    @�G�    @K
@   @`   @G^�`    @<k�    @
=�   @8(��    @D�p�   @1�f`   @7�z�    @BB�`   @"(��   @;p��    @L8Q�   @�
@   @H=p�    @IQ�   @.`   @A�G�    @@��@   @)�\    @4��    @4
=�   @3\    ?�\,     @?�`   @�\    @7��`    @F��`   ?���    @E�p�   . �- "+ @El��   @*��   @=p��   * @Ej=�   @2(��   @8��@   ) @E~�`   @=p�   @C��`   , ( @@p�   
@6:�@   ' @<�f`   @�Q�   @68Q�   & @9#�    @&��   @+W
       @% @/���   �/���   $ @@C�    @/z�@   @0�=`   # @A���   @�
@   @<c�       � �����                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                BookingsEmployeesMenu	Items
Orders.   I��F�X��'��yI�/                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            %sdasdsadsaads.	 +-Chicken Fingersfrieschickenno fries&	 )-Pastanonenoneno blueberries;	 '&burgersaladcucumbers@��    extra pickles@*��   ;	 '&burgersaladcucumbers?��    extra pickles@,`   ;		 '&burgersaladcucumbers?�(��   extra pickles@!B�`   ;	 '&burgersaladcucumbers?��
@   extra pickles@z�@   4	 '(burgersaladcucumbersextra pickles@-#�      !	 .Pastapotatoesnone�none
	 *)	 #-thing 1mashedpicklesno potatoes	 	(gasdfasfaaaaadasdsa<	 5(pastafriesnone?�
=�   no peppers or onions@!�z�   <	 5(pastafriesnone@z�   no peppers or onions@ff`   <	 5(pastafriesnone?����   no peppers or onions@)�\       � �����                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              !BurgerHand-Heldsy PastaDinnery� �G���                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         Jackson�� �l�2 -%Ed WardUseredward@gmail.comChef647-555-55457 %)%Robert WolfsAdminRWolf@wolfs.caOwner905-844-2323    jim5 #)%Robert WolfAdminRWolf@wolfs.cahead905-844-2323: %+%Jackson ReidAdminjreid@wolfs.comManager905-977-2333� � �������                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    eddy123
 eddy123 !jackson123 password #password123��������� password   #reg �@   � ��                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     2   "      		   m �mb                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              $adsdasdasdsaa   E	 #7%10:15DeepDecember 15windowfearthedeep@gmail.com905-666-7665J	 +)%7:00 pmJacksonAugust 12booth preferredjsmith@live.ca647-888-8843