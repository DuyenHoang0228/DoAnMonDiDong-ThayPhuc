package com.nhom4.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperSanPham extends SQLiteOpenHelper {

    public static final String DB_NAME="SanPhamLilPawHome.sqlite";
    public static final int DB_VERSION=1;

    public static final String TBL_NAME="SanPham";
    public static final String COL_ID="IDSanPham";
    public static final String COL_NAME="TenSanPham";
    public static final String COL_NEWPRICE="GiaSanPhamMoi";
    public static final String COL_OLDPRICE="GiaSanPhamCu";
    public static final String COL_DISCOUNT="GiamGiaSanPham";
    public static final String COL_IMAGE="HinhSanPham";
    public static final String COL_CATE1="LoaiSP1";
    public static final String COL_CATE2="LoaiSP2";
    public static final String COL_CATE3="LoaiSP3";
    public static final String COL_BRAND="ThuongHieuSP";
    public static final String COL_DES="MoTaSP";
    public static final String COL_RATE="SaoDanhGiaSP";
    public static final String COL_NUMORDER="LuotMuaSP";
    public static final String COL_NUMRATING="LuotDanhGiaSP";

    public DBHelperSanPham(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE IF NOT EXISTS " + TBL_NAME +
                " ("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME+" TEXT, "
                +COL_NEWPRICE+" REAL, "
                +COL_OLDPRICE+" REAL, "
                +COL_DISCOUNT+" REAL, "
                +COL_IMAGE+" TEXT, "
                +COL_CATE1+" VARCHAR(50), "
                +COL_CATE2+" VARCHAR(50), "
                +COL_CATE3+" VARCHAR(50), "
                +COL_BRAND+" VARCHAR(50), "
                +COL_DES+" TEXT, "
                +COL_RATE+" REAL, "
                +COL_NUMORDER+" REAL, "
                +COL_NUMRATING+" REAL "+ ")";
        sqLiteDatabase.execSQL(sql);
    }
//    tên là kiểu text, giá và discount kiểu double, hình ảnh là kiểu text, cate1-cate2-cate3 lần lượt là phân loại sản phẩm theo
//    cấp (cấp 1 là thức ăn, đồ dùng,...,; cấp 2 là con cấp 1 ví dụ thức ăn gồm hạt, sữa,...,;cấp 3 gồm 3 loại : hiếm, bán chạy và mới nhất )
//    rate là số sao đánh giá ví dụ 5 hay 4.5, numorder là số lượt mua, numrating là số lượt đánh giá

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void execSql(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
    public  int numOfRows()
    {
        Cursor cursor= getData(" SELECT * FROM "+ TBL_NAME);
        int count=cursor.getCount();
        cursor.close();
        return count;
    }
    public Cursor getData(String sql)
    {
        SQLiteDatabase db=getReadableDatabase();
        return db.rawQuery(sql,null);
    }
    public void createSampleData()
    {
        if(numOfRows()==20)
        {
//            chỗ này tui để bằng không để không cho nó insert lại bị trùng dữ liệu
            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Thức Ăn Organic Cho Mèo Con ANF 6 Free Indoor 6kg – Hàn Quốc',45000,60000,0.3,'hatchomeo1','thucanchomeo','hatchomeo','hiem','ANF','- Là một trong số những sản phẩm cho mèo hiếm hoi trên thị trường được làm từ các nguyên liệu Organic, 100% tự nhiên\n" +
                    "- Cam kết 6 KHÔNG về sản phẩm: Không có chất đột biến gen, không thuốc kháng sinh, không thuốc trừ sâu, không chất bảo quản, không màu tổng hợp, không thuốc tăng trưởng.\n" +
                    "- Công thức đặc biệt giúp mèo con cải thiện cân nặng và duy trì hệ miễn dịch tốt.\n" +
                    "- Có chứa các chất giúp lông và da mèo con được khỏe mạnh và sáng bóng.\n" +
                    "- Sản phẩm được sản xuất 100% tại Hàn Quốc, nơi có các công nghệ thực phẩm tiên tiến và hàng đầu thế giới.',4.5,1020,100)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Thức Ăn Organic Cho Mèo Lớn ANF 6 Free Indoor 6kg – Hàn Quốc',1233000,1370000,0.1,'hatchomeo2','thucanchomeo','hatchomeo','banchay','ANF','- Là một trong số những sản phẩm cho mèo hiếm hoi trên thị trường được làm từ các nguyên liệu Organic, 100% tự nhiên\n" +
                    "- Cam kết 6 KHÔNG về sản phẩm: Không có chất đột biến gen, không thuốc kháng sinh, không thuốc trừ sâu, không chất bảo quản, không màu tổng hợp, không thuốc tăng trưởng.\n" +
                    "- Công thức đặc biệt giúp mèo con cải thiện cân nặng và duy trì hệ miễn dịch tốt.\n" +
                    "- Có chứa các chất giúp lông và da mèo con được khỏe mạnh và sáng bóng.\n" +
                    "- Sản phẩm được sản xuất 100% tại Hàn Quốc, nơi có các công nghệ thực phẩm tiên tiến và hàng đầu thế giới.',4.5,1020,100)");
            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Thức Ăn Organic Cho Mèo Lớn ANF 6 Free Indoor 400g – Hàn Quốc',89000,99000,0.1,'hatchomeo3','thucanchomeo','hatchomeo','banchay','ANF','- Là một trong số những sản phẩm cho mèo hiếm hoi trên thị trường được làm từ các nguyên liệu Organic, 100% tự nhiên\n" +
                    "- Cam kết 6 KHÔNG về sản phẩm: Không có chất đột biến gen, không thuốc kháng sinh, không thuốc trừ sâu, không chất bảo quản, không màu tổng hợp, không thuốc tăng trưởng.\n" +
                    "- Công thức đặc biệt giúp mèo con cải thiện cân nặng và duy trì hệ miễn dịch tốt.\n" +
                    "- Có chứa các chất giúp lông và da mèo con được khỏe mạnh và sáng bóng.\n" +
                    "- Sản phẩm được sản xuất 100% tại Hàn Quốc, nơi có các công nghệ thực phẩm tiên tiến và hàng đầu thế giới.',4.5,1020,100)");
            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Sữa Tắm Cho Mèo Mượt Lông Beaphar Shampoo Cats',174000,200000,0.13,'suatamchomeo1','dodungchomeo','suatamchomeo','hiem','Beaphar','- Thương hiệu đến từ Hà Lan đạt tiêu chuẩn an toàn của Châu Âu.\n" +
                    "- Sản phẩm chứa công thức làm ẩm da cho mèo hỗ trợ lông mềm mượt và dễ chải.\n" +
                    "- Độ pH trung tính phù hợp với mọi loại da dù là da nhạy cảm.\n" +
                    "- Thể tích: 250 ml',4.5,1020,100)");
            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Sữa Tắm Cho Chó Trưởng Thành Beaphar Universal Dog',174000,200000,0.13,'suatamchocho1','dodungchocho','suatamchocho','moinhat','Beaphar','- Thương hiệu đến từ Hà Lan đạt tiêu chuẩn an toàn của Châu Âu.\n" +
                    "- Sản phẩm chứa công thức làm ẩm da cho mèo hỗ trợ lông mềm mượt và dễ chải.\n" +
                    "- Độ pH trung tính phù hợp với mọi loại da dù là da nhạy cảm.\n" +
                    "- Thể tích: 250 ml',4.5,1020,100)");
            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Vòng Cổ Cho Mèo Giảm Căng Thẳng Beaphar Collar',221000,250000,0.12,'phukienchomeo1','phukienchomeo','vongcochomeo','banchay','Beaphar','- Nhập khẩu hoàn toàn từ Hà Lan đạt tiêu chuẩn an toàn của Châu Âu.\n" +
                    "- Chiết xuất từ hoa nữ lang và oải hương với công dụng giảm stress, thư giản, bình tĩnh hơn.\n" +
                    "- Tinh dầu từ thiên nhiên sẽ giải phóng từ từ ra toàn bộ cơ thể qua da kéo dài 3-4 tuần.\n" +
                    "- Giảm các hành vi phá hoại của mèo khi căng thẳng như cào đồ đạc, đanh dấu mùi bằng cách đi vệ sinh.\n" +
                    "- Giúp mèo dễ dàng hòa nhập khi thay đổi môi trường sống (nơi ở mới…)\n" +
                    "- Thành phần tự nhiên đảm bảo an toàn và không gây kích ứng.',4.5,1020,100)");
            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Combo Vệ Sinh Răng Miệng Beaphar Tooth Combipack',266000,300000,0.11,'taimatchocho1','dodungchocho','taimatchocho','moinhat','Beaphar','- Kem đánh răng sở hữu các loại Enzyme đặc biệt tốt trong việc đánh bật các vết bẩn, mảng bám trên răng của chó mèo.\n" +
                    "- Có thể sử dụng hằng ngày, dùng kèm hoặc dùng riêng với các sản phẩm răng miệng khác đều tốt.\n" +
                    "- Bàn chải có thiết kế 2 đầu đặc biệt (1 đầu to, 1 đầu nhỏ) giúp thuận lợi trong việc chải các răng khác nhau của chó mèo',4.5,1020,100)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Pate Cho Mèo Ciao 14gx50 – Mix Vị – Thái',395000,457000,0.14,'patechomeo1','thuacanchomeo','patechomeo','hiem','Ciao','- Pate Ciao là thương hiệu quá nổi tiếng trên thị trường thức ăn dành cho mèo.\n" +
                    "- Nhờ sử dụng công nghệ Nhật Bản nên các thanh pate Ciao luôn có vị ngon đặc trưng riêng, kích thích vị giác của mèo và giúp mèo không cảm thấy ngán trong các bữa ăn hằng ngày.\n" +
                    "- Pate Ciao 14g có điểm mạnh là đa dạng hương vị, các loại thịt cá khác nhau và dễ tiêu hóa (do thức ăn đã được xay nhuyễn thành dạng sốt), từ đó giúp cho mèo ăn dễ dàng hơn và không ảnh hưởng nhiều đến hệ tiêu hóa của chúng.',4.5,954,100)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Pate Cho Mèo Ciao 14g – Thanh Lẻ – Mix Vị – Bổ Sung Vitamin – Thái',10000,12000,0.17,'patechomeo2','thuacanchomeo','patechomeo','hiem','Ciao','- Pate Ciao là thương hiệu quá nổi tiếng trên thị trường thức ăn dành cho mèo.\n" +
                    "- Nhờ sử dụng công nghệ Nhật Bản nên các thanh pate Ciao luôn có vị ngon đặc trưng riêng, kích thích vị giác của mèo và giúp mèo không cảm thấy ngán trong các bữa ăn hằng ngày.\n" +
                    "- Pate Ciao 14g có điểm mạnh là đa dạng hương vị, các loại thịt cá khác nhau và dễ tiêu hóa (do thức ăn đã được xay nhuyễn thành dạng sốt), từ đó giúp cho mèo ăn dễ dàng hơn và không ảnh hưởng nhiều đến hệ tiêu hóa của chúng.',4.5,954,100)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Pate Cho Mèo Ciao Churu Cho Mèo Con (14gx20) – Hãng Nhật – Hàng Thái',155000,200000,0.23,'patechomeo3','thuacanchomeo','patechomeo','hiem','Ciao','- Pate dạng kem thưởng, phù hợp với mèo ở mọi độ tuổi.\n" +
                    "- Làm thức ăn snack hoặc thức ăn sáng cho mèo, giúp bổ sung thêm dinh dưỡng cho mèo.\n" +
                    "- Bạn có thể trộn pate tươi chung với hạt hoặc các loại thức ăn chính để kích thích hương vị cho mèo.\n" +
                    "- Được làm từ các loại thịt cá tươi theo đúng tiêu chuẩn sản xuất chuyên nghiệp của Thái Lan.',4.5,954,100)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Thức Ăn Cho Mèo Con Catsrang Kitten 1.5kg – Hàn Quốc',210000,225000,0.07,'hatchomeo4','thuacanchomeo','patechomeo','banchay','Catstrang','- Hạt có công thức giúp loại bỏ mùi hôi của chất thải mèo và giúp phân chắc hơn, không bị lỏng.\n" +
                    "- Hàm lượng dinh dưỡng trong 1 viên khá nhiều, đủ cho mèo phát triển cơ thể.\n" +
                    "- Hạt giúp da và lông mèo đẹp, bóng mượt hơn cũng như ngăn ngừa được bênh quáng gà.\n" +
                    "- Hoàn toàn không gây hại cho sức khỏe của mèo bởi hạt không có kháng sinh, chất bảo quản, hương nhân tạo hay phẩm màu tổng hợp.\n" +
                    "- Sản xuất 100% tại Hàn Quốc và nhập về Việt Nam theo đường chính ngạch có tem xuất xứ rõ ràng.',4.5,954,100)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Khay Vệ Sinh Ferplast Maxi Bella Cabrio',1090000,2000000,0.46,'khaychocho1','dodungchocho','khayvesinhchocho','hiem','ferplast','- Khay vệ sinh cho mèo được nhập 100% từ Ý\n" +
                    "- Khay vệ sinh kín, giúp mùi hôi không bay ra ngoài\n" +
                    "- Kích cỡ lớn, giúp thú cưng thoải mái\n" +
                    "- Tặng kèm 1 miếng than hoạt tính khử mùi\n" +
                    "- 2 màu: Xanh Dương, Đen',4.5,954,100)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Khay Vệ Sinh Ferplast Maxi Bella Cabrio',1090000,2000000,0.46,'khaychomeo1','dodungchocho','khayvesinhchocho','hiem','ferplast','- Khay vệ sinh cho mèo được nhập 100% từ Ý\n" +
                    "- Khay vệ sinh kín, giúp mùi hôi không bay ra ngoài\n" +
                    "- Kích cỡ lớn, giúp thú cưng thoải mái\n" +
                    "- Tặng kèm 1 miếng than hoạt tính khử mùi\n" +
                    "- 2 màu: Xanh Dương, Đen',4.5,954,100)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Dây Dắt Ferplast Ergoflex (1.8cm/110cm)',562000,700000,0.06,'daydatchocho1','phukienchocho','daydatchocho','hiem','ferplast','- Dây dắt chó được nhập khẩu từ Ý\n" +
                    "- Có tay cầm được thiết kế mềm mại, không gây đau cho chủ nuôi\n" +
                    "- Dây cao su đàn hồi giúp giảm lực tác động lên cổ tay chủ\n" +
                    "- 2 màu: Xanh Lá, Xám\n" +
                    "- 2 size',4,954,100)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Yếm Ferplast Ergoflex (S)',598000,700000,0.15,'daydatchocho2','phukienchocho','daydatchocho','hiem','ferplast','- Yếm cho chó được nhập khẩu từ Ý\n" +
                    "- Làm từ cao su tự nhiên giúp chó luôn cảm thấy thoải mái\n" +
                    "- 2 màu: Xanh Lá, Xám\n" +
                    "- 2 size (S, M)',4,954,100)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Lược Cào Furminator Fur Cho Chó – Mỹ',346000,400000,0.14,'longmongchocho1','dodungchocho','longmongchocho','hiem','furminator','- Lược cào được làm từ kim loại thép không gỉ, có tuổi thọ cao.\n" +
                    "- Phần đế được làm từ cao su, không gây trượt tay khi bạn chải lông cho chó.\n" +
                    "- Lược có phần đầu nhọn giúp vừa mát xa lại vừa làm mượt lông của chó.',4,302,50)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Lược Chải Mèo Lông Dài Furminator Deshedding – Mỹ',633000,700000,0.13,'longmongchomeo1','dodungchomeo','longmongchomeo','hiem','furminator','- Công nghệ Deshedding được cấp bằng sáng chế, giảm rụng lông đến 90%\n" +
                    "- Có nút bấm Furejector, giúp tách lông ra khỏi lược đơn giản\n" +
                    "- Bàn chải dễ dàng cắt xuyên qua lớp lông một cách an toàn\n" +
                    "- Sản phẩm sử dụng lưỡi dao thép không gỉ nên an toàn và có thể dùng lâu dài.\n" +
                    "- Tay cầm được phủ một lớp cao su giúp bạn không bị đau khi cầm lược,\n" +
                    "- Được sản xuất 100% tại Mỹ và nhập khẩu chính ngạch nên sản phẩm đã được kiểm duyệt chất lượng,',4,302,50)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Bình Xịt Gỡ Rối Lông Furminator Shampoo – Mỹ',188000,425000,0.25,'longmongchocho2','dodungchocho','longmongchocho','moinhat','furminator','- Bình xịt có chức năng làm mượt lông, hạn chế lông chó bị rối.\n" +
                    "- Có mùi thơm dịu nhẹ, giúp bạn có thể sử dụng thay thế cho sữa tắm trong những ngày bạn không tắm cho chó.\n" +
                    "- Cực kì an toàn vì sản phẩm được sản xuất 100% tại Hoa Kỳ với chất lượng được kiểm duyệt gắt gao.',4,302,50)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Banh Đồ Chơi Cho Chó Kong Winner (M) – Mỹ',159000,200000,0.21,'banhbongchocho1','dochoichocho','banhbongchocho','moinhat','kong','- Là sản phẩm đồ chơi được nghiên cứu và sản xuất 100% tại USA\n" +
                    "- Đồ chơi thuộc hãng Kong nổi tiếng, đây là hãng chuyên về đồ chơi cho thú cưng hàng đầu của Mỹ.\n" +
                    "- Banh thiết kế chắc chắn, không bị hư khi chó cắn thường xuyên\n" +
                    "- Chất liệu banh rất an toàn, nên không ảnh hưởng tới sức khỏe của chó khi chơi.\n" +
                    "- Không hại răng của chó khi banh mềm\n" +
                    "- Khác với banh truyền thống, banh Kong không bị mài mòn theo thời gian.',4,302,50)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Banh Nhét Snack Cho Chó Kong Classic (M) – Cực Bền – Mỹ',332000,400000,0.1,'banhbongchocho2','dochoichocho','banhbongchocho','moinhat','kong','- Banh là sản phẩm đồ chơi nổi tiếng của thương hiệu Kong, Hoa Kỳ.\n" +
                    "- Được làm từ cao su đặc, nên có độ bền rất tốt so với các sản phẩm đồ chơi thông thường.\n" +
                    "- Banh mềm vừa phải, không quá cứng nên không làm ảnh hưởng đến răng miệng của cún cưng,\n" +
                    "- Sản phẩm chống nước tốt, không bị biến dạng khi chó cắn mạnh.\n" +
                    "- Có 2 size S và M phù hợp với chó có kích cỡ từ nhỏ cho tới trung bình.',4,302,50)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Xương Cao Su Kong Extreme (M) – Mỹ',305000,350000,0.13,'xuongchocho1','dochoichocho','xuongchocho','moinhat','kong','- Là sản phẩm đồ chơi cho chó đến từ thương hiệu đồ chơi cho thú cưng số 1 của Mỹ\n" +
                    "- Được làm từ cao su nguyên chất, với độ đàn hồi tốt và bền bỉ theo thời gian.\n" +
                    "- Sản phẩm đã được kiểm nghiệm là an toàn với sức khỏe của chó.\n" +
                    "- Xương có độ cứng tốt, giúp chó thoải mái cắn giỡn mà không lo bị hư.\n" +
                    "- Sản phẩm có thiết kế đặc biệt với chỗ đựng thức ăn/bánh thưởng để kích thích chó chơi đùa.',4,302,50)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Bàn Cào Móng Mon Ami Cat Tree Katia',292000,300000,0.03,'caomongchomeo1','dochoichomeo','caomongchomeo','banchay','mon-ami','- Sản xuất tại Việt Nam\n" +
                    "- Được bện dây thừng chắc chắn, không dễ đứt\n" +
                    "- Hỗ trợ mèo không bị ngứa móng\n" +
                    "- Bảo vệ đồ dùng gia đình bạn, tránh bị mèo quào',4,302,50)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Cần Câu Cá Đồ Chơi Mon Ami Toy Cat',24000,40000,0.4,'cancauchomeo1','dochoichomeo','cancauchomeo','hiem','mon-ami','- Sản xuất tại Việt Nam\n" +
                    "- Chất liệu tốt, có độ bền cao\n" +
                    "- Kích thích sự tò mò của mèo',4,302,50)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Đồ Chơi Nhồi Bông Hình Đôi Chuột Mon Ami Toy Cat',45000,60000,0.25,'goibongchomeo1','dochoichomeo','goibongchomeo','moinhat','mon-ami','- Sản xuất tại Việt Nam\n" +
                    "- Chất liệu tốt, có độ bền cao\n" +
                    "- Kích thích sự tò mò của mèo',4,302,50)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Mặt Vòng Cổ Hình Trái Tim Mon Ami Jewelry',65000,70000,0.07,'vongcochomeo1','phukienchomeo','vongcochomeo','moinhat','mon-ami','- Sản xuất tại Việt Nam\n" +
                    "- Chất liệu tốt, có độ bền cao\n" +
                    "- Kích thích sự tò mò của mèo',4,302,50)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Mặt Vòng Cổ Hình Trái Tim Mon Ami Jewelry',75000,80000,0.12,'vongcochocho1','phukienchocho','vongcochocho','moinhat','mon-ami','- Sản xuất tại Việt Nam\n" +
                    "- Chất liệu tốt, có độ bền cao\n" +
                    "- Kích thích sự tò mò của mèo',4,302,50)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Cây Chó Leo Mon Ami Cat Tree Liza',1000000,2000000,0.17,'caomongchocho1','dochoichocho','caomongchocho','hiem','mon-ami','- Sản xuất tại Việt Nam\n" +
                    "- Được bện dây thừng chắc chắn, không dễ đứt\n" +
                    "- Hỗ trợ chó không bị ngứa móng\n" +
                    "- Bảo vệ đồ dùng gia đình bạn, tránh bị  quào chó',4,302,50)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Banh Lục Lạc Mon Ami Toy Cat',45000,50000,0.1,'banhbongchomeo1','dochoichomeo','banhbongchomeo','moinhat','mon-ami','- Sản xuất tại Việt Nam\n" +
                    "- Được bện dây thừng chắc chắn, không dễ đứt\n" +
                    "- Hỗ trợ chó không bị ngứa móng\n" +
                    "- Bảo vệ đồ dùng gia đình bạn, tránh bị  quào chó',4,405,50)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Pate Monge Cho Chó Điều Trị Viêm Da 150g – Ý',31000,40000,0.23,'patechocho1','thucanchocho','patechocho','hiem','monge','- Viêm da là căn bệnh mà nhiều người nuôi chó sẽ luôn đau đầu vì đây là căn bệnh khó chữa trị và lại mất thời gian để điều trị.\n" +
                    "- Do đó, lựa chọn các loại sản phẩm giúp hỗ trợ điều trị viêm da cho chó sẽ giúp cho bạn yên tâm hơn khi nuôi chó cũng như cải thiện tình trạng sữa khoẻ của cún cưng rõ rệt.\n" +
                    "- Monge là thương hiệu pate nổi tiếng của Ý với các dòng pate thương hạng và thơm ngon. Trong đó, dòng pate điều trị bệnh của Monge là nổi tiếng nhất.\n" +
                    "- Chứa Nucleotides để hỗ trợ hệ thống miễn dịch, Lô hội hỗ trợ làn da, Xylo-oligosaccharides (XOS) để đảm bảo hệ vi sinh vật đường ruột và hàm lượng axit béo thiết yếu cao.\n" +
                    "- Pate hỗ trợ điều trị bệnh viêm da của Monge đều được các bác sĩ Thú Y công nhận về chất lượng và độ hiệu quả trong quá trình điều trị và cải thiện bệnh ở cún cưng.\n" +
                    "- Sản phẩm phù hợp với chó ở mọi lứa tuổi.\n" +
                    "- Monge đã được hội Thú Y kiểm định là an toàn và hiệu quả để chữa bệnh cho chó.',4,405,50)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Pate Cho Chó Monge Fresh Gà Và Rau 100g – Ý',40000,450000,0.2,'patechocho2','thucanchocho','patechocho','hiem','monge','- Pate được làm từ 100% thịt tươi với đầy đủ các chất dinh dưỡng cần thiết cho chó.\n" +
                    "- Một số vị còn được trồn kèm với rau củ để bổ sung thêm vitamin vầ khoáng chất cho cún cưng\n" +
                    "- Hương vị thơm ngon, dễ ăn, dễ sử dụng.\n" +
                    "- Bạn có thể trộn pate với thức ăn hàng ngày hoặc cho chó ăn riêng đều tốt.\n" +
                    "- Được sản xuất tại Ý với dây chuyền chế biến khép kín và chặt chẽ.\n" +
                    "- Có HSD xa, đảm bảo bạn có thể yên tâm mua cho chó ăn.',4,405,200)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Pate Cho Chó Monge Fruit Gà Tây Và Việt Quất 100g – Ý',47000,50000,0.06,'patechocho3','thucanchocho','patechocho','moinhat','monge','- Pate được làm từ 100% thịt tươi với đầy đủ các chất dinh dưỡng cần thiết cho chó.\n" +
                    "- Một số vị còn được trồn kèm với rau củ để bổ sung thêm vitamin vầ khoáng chất cho cún cưng\n" +
                    "- Hương vị thơm ngon, dễ ăn, dễ sử dụng.\n" +
                    "- Bạn có thể trộn pate với thức ăn hàng ngày hoặc cho chó ăn riêng đều tốt.\n" +
                    "- Được sản xuất tại Ý với dây chuyền chế biến khép kín và chặt chẽ.\n" +
                    "- Có HSD xa, đảm bảo bạn có thể yên tâm mua cho chó ăn.',4,405,200)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Pate Cho Chó Monge Fresh Thịt Vịt 100g – Ý',47000,50000,0.06,'patechocho4','thucanchocho','patechocho','moinhat','monge','- Pate được làm từ 100% thịt tươi với đầy đủ các chất dinh dưỡng cần thiết cho chó.\n" +
                    "- Một số vị còn được trồn kèm với rau củ để bổ sung thêm vitamin vầ khoáng chất cho cún cưng\n" +
                    "- Hương vị thơm ngon, dễ ăn, dễ sử dụng.\n" +
                    "- Bạn có thể trộn pate với thức ăn hàng ngày hoặc cho chó ăn riêng đều tốt.\n" +
                    "- Được sản xuất tại Ý với dây chuyền chế biến khép kín và chặt chẽ.\n" +
                    "- Có HSD xa, đảm bảo bạn có thể yên tâm mua cho chó ăn.',4,405,200)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Pate Cho Mèo Gravy Nekko 70g – Vị Cá Ngừ Rắc Tôm',47000,50000,0.06,'patechomeo4','thucanchomeo','patechomeo','hiem','nekko','- Pate Nekko cho mèo bổ sung Omega-3 và Omega-6 giúp cải thiện da và lông.\n" +
                    "- Cung cấp taurine, 1 loại amino acid quan trọng với mèo. Giúp cải thiện mắt và tăng khả năng nhìn trong bóng tối\n" +
                    "- Công thức bao gồm Limonite, một loại khoáng chất được tìm thấy ở phía Nam Nhật Bản, giúp giảm mùi hôi chất thải.\n" +
                    "- Bổ sung vitamin E cho mèo nhằm giúp mèo có sức đề kháng tốt hơn.\n" +
                    "- Pate Nekko có 3 dạng: dạng nhuyễn (cho mèo con), dạng thạch Jelly (cho mèo trưởng thành) và dạng sốt lỏng Gravy (cho mèo trưởng thành)',4,405,200)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Pate Cho Mèo Gravy Nekko 70g – Vị Cá Ngừ Rắc Thịt Gà',47000,50000,0.06,'patechomeo5','thucanchomeo','patechomeo','moinhat','nekko','- Pate Nekko cho mèo bổ sung Omega-3 và Omega-6 giúp cải thiện da và lông.\n" +
                    "- Cung cấp taurine, 1 loại amino acid quan trọng với mèo. Giúp cải thiện mắt và tăng khả năng nhìn trong bóng tối\n" +
                    "- Công thức bao gồm Limonite, một loại khoáng chất được tìm thấy ở phía Nam Nhật Bản, giúp giảm mùi hôi chất thải.\n" +
                    "- Bổ sung vitamin E cho mèo nhằm giúp mèo có sức đề kháng tốt hơn.\n" +
                    "- Pate Nekko có 3 dạng: dạng nhuyễn (cho mèo con), dạng thạch Jelly (cho mèo trưởng thành) và dạng sốt lỏng Gravy (cho mèo trưởng thành)',5,502,200)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Chén Nhựa Hình Hoa 3 Cánh Pawise Feeding',20000,25000,0.2,'chenanchocho1','dodungchocho','chenanchocho','moinhat','pawise','- Thương hiệu nổi tiếng ở Châu Âu và Mỹ\n" +
                    "- Nhựa tổng hợp an toàn cho thú cưng\n" +
                    "- Thiết kế thấp, thú cưng không phải rướn khi ăn',5,502,200)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Chén Sứ Vành Thấp Màu Vàng Pawise Feeding',20000,25000,0.2,'chenanchocho2','dodungchocho','chenanchocho','moinhat','pawise','- Thương hiệu nổi tiếng ở Châu Âu và Mỹ\n" +
                    "- Nhựa tổng hợp an toàn cho thú cưng\n" +
                    "- Thiết kế thấp, thú cưng không phải rướn khi ăn',5,502,200)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Chén Sứ Vành Thấp Màu Đen Pawise Feeding',20000,25000,0.2,'chenanchocho3','dodungchocho','chenanchocho','moinhat','pawise','- Thương hiệu nổi tiếng ở Châu Âu và Mỹ\n" +
                    "- Nhựa tổng hợp an toàn cho thú cưng\n" +
                    "- Thiết kế thấp, thú cưng không phải rướn khi ăn',5,502,200)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Chén Sứ Verona Đỏ Pawise Feeding (S)',135000,150000,0.1,'chenanchomeo1','dodungchomeo','chenanchomeo','hiem','pawise','- Thương hiệu nổi tiếng ở Châu Âu và Mỹ\n" +
                    "- Nhựa tổng hợp an toàn cho thú cưng\n" +
                    "- Thiết kế thấp, thú cưng không phải rướn khi ăn',5,502,200)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Chén Sứ Verona Đỏ Pawise Feeding (M)',160000,200000,0.2,'chenanchomeo1','dodungchomeo','chenanchomeo','hiem','pawise','- Thương hiệu nổi tiếng ở Châu Âu và Mỹ\n" +
                    "- Nhựa tổng hợp an toàn cho thú cưng\n" +
                    "- Thiết kế thấp, thú cưng không phải rướn khi ăn',5,502,200)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Chén Sứ Verona Đỏ Pawise Feeding (L)',300000,350000,0.14,'chenanchomeo1','dodungchomeo','chenanchomeo','hiem','pawise','- Thương hiệu nổi tiếng ở Châu Âu và Mỹ\n" +
                    "- Nhựa tổng hợp an toàn cho thú cưng\n" +
                    "- Thiết kế thấp, thú cưng không phải rướn khi ăn',5,502,200)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Chén Sứ Vành Cao Màu Vàng Pawise Feeding (S)',80000,100000,0.2,'chenanchomeo2','dodungchomeo','chenanchomeo','hiem','pawise','- Thương hiệu nổi tiếng ở Châu Âu và Mỹ\n" +
                    "- Nhựa tổng hợp an toàn cho thú cưng\n" +
                    "- Thiết kế thấp, thú cưng không phải rướn khi ăn',5,502,200)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Chén Sứ Vành Cao Màu Vàng Pawise Feeding (M)',100000,150000,0.33,'chenanchomeo2','dodungchomeo','chenanchomeo','hiem','pawise','- Thương hiệu nổi tiếng ở Châu Âu và Mỹ\n" +
                    "- Nhựa tổng hợp an toàn cho thú cưng\n" +
                    "- Thiết kế thấp, thú cưng không phải rướn khi ăn',5,502,200)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Chén Sứ Vành Cao Màu Vàng Pawise Feeding (L)',150000,200000,0.25,'chenanchomeo2','dodungchomeo','chenanchomeo','hiem','pawise','- Thương hiệu nổi tiếng ở Châu Âu và Mỹ\n" +
                    "- Nhựa tổng hợp an toàn cho thú cưng\n" +
                    "- Thiết kế thấp, thú cưng không phải rướn khi ăn',5,502,200)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Sữa Cho Chó Mèo AG 250g – Công Thức Sữa Dê – Thái Lan',450000,560000,0.2,'suachocho1','thucanchocho','suachocho','banchay','agscience','- Thành phần từ công thức sữa dê, không chứa lactose, an toàn cho hệ tiêu hóa của chó mèo con.\n" +
                    "- Với men Beta Glucan có trong sản phẩm giúp phòng tránh nguy cơ các bệnh tim mạch nguy hiểm, tăng nhu động ruột, cải thiện hệ tiêu hóa, chống lại các nhiễm trùng do sức khỏe của chó mèo mới sinh còn yếu.\n" +
                    "- Hàm lượng Insulin điều chỉnh sự chuyển hóa carbohydrate, chất béo và protein bằng cách thúc đẩy sự hấp thụ glucose từ máu vào tế bào gan, mỡ và cơ xương, Hỗ trợ phát triển toàn diện và cân bằng tăng trưởng.\n" +
                    "- Cung cấp nguồn Vitamin thiết yếu nhằm tăng cường miễn dịch và sức đề kháng.',5,502,200)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Sữa Cho Chó Mèo AG 250g – Công Thức Sữa Dê – Thái Lan',450000,560000,0.2,'suachomeo1','thucanchomeo','suachomeo','banchay','agscience','- Thành phần từ công thức sữa dê, không chứa lactose, an toàn cho hệ tiêu hóa của chó mèo con.\n" +
                    "- Với men Beta Glucan có trong sản phẩm giúp phòng tránh nguy cơ các bệnh tim mạch nguy hiểm, tăng nhu động ruột, cải thiện hệ tiêu hóa, chống lại các nhiễm trùng do sức khỏe của chó mèo mới sinh còn yếu.\n" +
                    "- Hàm lượng Insulin điều chỉnh sự chuyển hóa carbohydrate, chất béo và protein bằng cách thúc đẩy sự hấp thụ glucose từ máu vào tế bào gan, mỡ và cơ xương, Hỗ trợ phát triển toàn diện và cân bằng tăng trưởng.\n" +
                    "- Cung cấp nguồn Vitamin thiết yếu nhằm tăng cường miễn dịch và sức đề kháng.',5,502,200)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Sữa Tắm Cho Mèo Con 8in1 Perfect Coat',200000,350000,0.43,'suatamchomeo2','dodungchomeo','suatamchomeo','banchay','eightin1','- Thương hiệu Mỹ\n" +
                    "- Công thức đặc biệt gồm chất Jojoba và Keratin giúp lông chắc khỏe\n" +
                    "- Hương thơm lâu dài',5,502,200)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Sữa Tắm Trị Bọ Chét 8in1 Perfect Coat',200000,350000,0.43,'suatamchocho2','dodungchocho','suatamchocho','banchay','eightin1','- Thương hiệu Mỹ\n" +
                    "- Công thức đặc biệt gồm chất Jojoba và Keratin giúp lông chắc khỏe\n" +
                    "- Hương thơm lâu dài',5,502,200)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Sữa Tắm Cho Chó Lông Đen 8in1 Perfect Coat',200000,350000,0.43,'suatamchocho3','dodungchocho','suatamchocho','banchay','eightin1','- Thương hiệu Mỹ\n" +
                    "- Công thức đặc biệt gồm chất Jojoba và Keratin giúp lông chắc khỏe\n" +
                    "- Hương thơm lâu dài',5,502,200)");

            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Cát Vệ Sinh Genki 5L – Lưu Hương Và Khử Mùi – Nhật Bản',150000,200000,0.25,'catchomeo1','dodungchomeo','catmeo','moinhat','genki','- Cát Genki được sản xuất theo tiêu chuẩn dây chuyền công nghệ tân tiến của Nhật bản, sở hữu nhiều ưu điểm vượt trội.\n" +
                    "- Thành phần từ 100% bentonite tự nhiên cùng các hạt silicat lưu huơng và khử mùi ưu việt.\n" +
                    "- Chậu cát luôn khô ráo nhờ vào độ hút ẩm và vón siêu tốt của sản phẩm, không lo bết đáy chậu cát vệ sinh.\n" +
                    "- Không chứa thành phần gây hại, không bụi nên an toàn cho mèo khi sử dụng.\n" +
                    "- Có đa dạng các mùi hương dễ chịu.\n" +
                    "Hướng dẫn sử dụng:\n" +
                    "- Đổ cát ra chậu vệ sinh và dàn đều với độ dày khoảng 5-7cm\n" +
                    "- Sau khi mèo đi vệ sinh, cát sẽ vón cục =>> dùng xẻng lấy phần vón cục và loại bỏ.',5,502,200)");







//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Cát Gỗ Hữu Cơ Cho Mèo Cats Best Original 30L (13kg) – Đức',150000,200000,0.25,'catchomeo2','dodungchomeo','catmeo','hiem','catbest','- Trên thị trường hiện nay, có 3 dòng cát vệ sinh chính cho mèo bao gồm: Cát đất sét, cát thuỷ tinh và cát hữu cơ. Trong đó cát hữu cơ được xem là dòng cát mới nhất với nhiều tính năng rất tốt cho người nuôi mèo.\n" +
//                    "- Cát hữu cơ là cát được làm hoàn toàn 100% từ các vật liệu tự nhiên như bột đậu nành, bột bắp hay vụn gỗ.\n" +
//                    "- Ưu điểm hàng đầu của cát hữu cơ là rất an toàn với mèo, kể cả khi mèo vô tình ngửi hoặc ăn cát.\n" +
//                    "- Hơn nữa, cát hữu cơ lại dễ dọn dẹp và chùi rửa. Bạn có thể đổ cát vào trong bồn cầu và giật nước hay đem đổ ra đất là phân bón đều rất tốt.\n" +
//                    "- Cats Best Original là dòng sản phẩm cát hữu cơ của Đức đi đầu trong việc cải thiện chất lượng nuôi mèo và chất lượng sống của người nuôi.',5,502,200)");
//
//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Kẹo Sữa Hình Xương Pow Milk Tablet 20g – Thái Lan – Hàng Hiếm',25000,30000,0.17,'snackchomeo1','thucanchomeo','snackchomeo','banchay','thuonghieukhac','- Kẹo sữa là sản phẩm giúp bạn vừa chơi với thú cưng mà cũng giúp tăng cảm giác thèm ăn và bổ sung dinh dưỡng cho chó mèo ở giai đoạn sơ sinh và nhỏ.\n" +
//                    "- Là sản phẩm của Thái với hương vị thơm ngon và thu hút được sự chú ý của các bé cún mèo, kẹo sẽ giúp cho bé thấy ăn uống ngon hơn.\n" +
//                    "- Sản phẩm có 3 vị là sữa truyền thống, gan bò và cá hồi. Giúp bạn có thể thoải mái đổi vị mà không lo thú cưng thấy ngán.\n" +
//                    "- Mỗi ngày bạn có thể cho bé ăn từ 2 - 3 viên kẹo, chia đều trong hoặc sau các bữa ăn chính.\n" +
//                    "- Sản phẩm được sản xuất tại Thái Lan, nơi có ngành thú cưng cực kì phát triển, nên chất lượng sản phẩm đã được kiểm định và đảm bảo vệ sinh an toàn thực phẩm.\n" +
//                    "- Khi không dùng đến, bạn có thể bỏ kẹo ở nơi khô ráo hoặc cho vào hộp có nắp đậy để giữ cho kẹo có hương vị thơm ngon trong một thời gian dài.',5,502,200)");
//
//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Xúc Xích Phô Mai Bowwow 240g – Không Hương Liệu – Hàn Quốc',25000,30000,0.17,'snackchocho1','thucanchocho','snackchocho','hiem','thuonghieukhac','- Xúc xích giúp tăng khẩu vị cho chó mèo, đặc biệt là những bé thú cưng kén ăn.\n" +
//                    "- Bạn có thể cho thú cưng ăn kèm với cơm hoặc làm thức ăn phụ cho mỗi bữa sáng của chó mèo.\n" +
//                    "- Sản phẩm được làm 100% từ thịt tươi với công thức không chất bảo quản và không hương liệu.\n" +
//                    "- Ngoài thịt chứa nhiều Protein thì phô mai còn giúp cải thiện tiêu hoá, bổ sung men vi sinh giúp bụng chó mèo hấp thụ dinh dưỡng tốt hơn.\n" +
//                    "- Công nghệ chế biến an toàn với lượng muối thấp, nên sẽ gây hại tới thận và tim của thú cưng.\n" +
//                    "- Nguyên vật liệu được chế biến với công nghệ dây chuyền khép kín, giúp giữ nguyên được dinh dưỡng và chất lượng của thịt tới khi chó mèo cưng ăn.\n" +
//                    "- Sản phẩm có mùi vị phô mai béo ngậy, kích thích vị giác của thú cưng, ngay cả những bé “boss\" kén ăn nhất.\n" +
//                    "- Xúc xích Bowwow được sử dụng cho cả chó và mèo.\n" +
//                    "- Phù hợp thú cưng ở mọi giai đoạn và lứa tuổi khác nhau.\n" +
//                    "- Sản phẩm được sản xuất 100% tại Hàn Quốc nên bạn sẽ yên tâm khi cho thú cưng ăn mỗi ngày.',5,502,200)");
//
//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Snack Thưởng Mềm Juicy Bites 11g – 2 Vị Trong 1 Gói – Thái Lan',55000,60000,0.15,'snackchocho2','thucanchocho','snackchocho','hiem','thuonghieukhac','- Khi nuôi chó, ngoài thức ăn hạt và các loại pate kem thưởng ra, chắc hẳn đôi khi bạn sẽ băn khoăn không biết nên cho chó ăn gì để bạn có thể vừa chơi với chúng mà lại có thể dễ dàng huấn luyện chó theo ý mình.\n" +
//                    "- Đây là lúc bạn cần phải mua ngay snack bánh thưởng Juicy Bites.\n" +
//                    "- Sản phẩm có thành phần không những giúp chó ăn vặt mà còn bổ sung một số chất dinh dưỡng cho hoạt động sống hằng ngày.\n" +
//                    "- Juicy Bites là dòng sản phẩm đến từ Thái Lan, với thiết kế viên snack đặt biệt vừa mềm lại vừa thơm, giúp kích thích khứu giác và vị giác của những chú chó.\n" +
//                    "- Không những thế, một gói bánh thưởng Juicy Bites sẽ bao gồm 2 vị riêng biệt giúp cho chó của bạn không cảm thấy ngán mà bạn cũng có thêm nhiều sự lựa chọn hơn.',5,502,200)");
//
//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Snack Ăn Sạch Răng Cho Chó Feline Greenies 595g – Cực Hiếm – USA',700000,800000,0.13,'snackchocho3','thucanchocho','snackchocho','hiem','thuonghieukhac','- Khi nuôi chó, ngoài thức ăn hạt và các loại pate kem thưởng ra, chắc hẳn đôi khi bạn sẽ băn khoăn không biết nên cho chó ăn gì để bạn có thể vừa chơi với chúng mà lại có thể dễ dàng huấn luyện chó theo ý mình.\n" +
//                    "- Đây là lúc bạn cần phải mua ngay snack bánh thưởng Juicy Bites.\n" +
//                    "- Sản phẩm có thành phần không những giúp chó ăn vặt mà còn bổ sung một số chất dinh dưỡng cho hoạt động sống hằng ngày.\n" +
//                    "- Juicy Bites là dòng sản phẩm đến từ Thái Lan, với thiết kế viên snack đặt biệt vừa mềm lại vừa thơm, giúp kích thích khứu giác và vị giác của những chú chó.\n" +
//                    "- Không những thế, một gói bánh thưởng Juicy Bites sẽ bao gồm 2 vị riêng biệt giúp cho chó của bạn không cảm thấy ngán mà bạn cũng có thêm nhiều sự lựa chọn hơn.',5,502,200)");
//
//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Snack Bánh Thưởng Me-O 50g – Đủ Vị Cho Mèo – Thái Lan',25000,30000,0.17,'snackchomeo2','thucanchomeo','snackchomeo','banchay','thuonghieukhac','- Khi nuôi mèo, ngoài hạt khô và pate ra thì snack thưởng cũng là một loại thực phẩm mà bạn nên trang bị khi mua sắm.\n" +
//                    "- Snack thưởng giúp kích thích vị giác của mèo nhiều hơn. Bạn cũng có thể dùng bánh thưởng để khen mèo khi bắt đầu các bài huấn luyện thay đổi hành vi cho chúng.\n" +
//                    "- Snack thưởng cho mèo Me-o là dòng sản phẩm mới ra trên thị trường hiện nay.\n" +
//                    "- Sản phẩm có nhiều mùi vị thơm ngon giúp mèo ăn nhiều hơn.\n" +
//                    "- Snack Me-o đảm bảo sẽ giúp cho mèo của bạn thích thú hơn trong việc ăn uống.',5,502,200)");
//
//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Súp Kem Thưởng Wanpy Happy 100 14gx5',55000,60000,0.15,'snackchomeo3','thucanchomeo','snackchomeo','banchay','thuonghieukhac','- Nếu bạn đang bắt đầu nuôi mèo hoặc đã nuôi mèo lâu thì kem thưởng là sản phẩm không thể nào thiếu khi mua đồ cho mèo.\n" +
//                    "- Kem thưởng kích thích sức ăn của mèo, giúp cho mèo bớt kén ăn hơn và bổ sung thêm nhiều dinh dưỡng khác ngoài hạt.\n" +
//                    "- Kem thưởng cũng cung cấp thêm nước cho cơ thể của mèo, rất tốt trong việc phòng tránh các bệnh liên quan đến thận của mèo.\n" +
//                    "- Sản phẩm Happy Wanpy 100 là một trong những thương hiệu đã rất nổi tiếng trên thị trường nội địa Trung. Nay, bạn có thể mua sản phẩm này cho mèo nhà thưởng thức.\n" +
//                    "- Kem thưởng có 5 vị để bạn có thể thay phiên cho mèo ăn để giúp mèo thấy ngon miệng hơn.\n" +
//                    "- Bạn có thể cho mèo liếm kem trực tiếp trên tay hoặc trộn chung với các loại thức ăn khác để tăng thêm khẩu vị cho mèo.',5,502,200)");
//
//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Sữa Cho Mèo Con Beaphar Lactol Kitten Milk (500g)',450000,502000,0.1,'suachomeo2','thucanchomeo','suachomeo','banchay','beaphar','- Sở hữu công thức đặc biệt giúp mèo hấp thu chất dinh dưỡng trong sữa nhanh hơn.\n" +
//                    "- Bổ sung các dưỡng chất và vitamin cần thiết, giúp mèo nhanh chóng phát triển.\n" +
//                    "- Hoàn toàn an toàn với mèo.\n" +
//                    "- Phù hợp với mèo sơ sinh và mèo con dưới 12 tháng tuổi.\n" +
//                    "- Được sản xuất 100% tại Hà Lan, theo tiêu chuẩn an toàn của Châu Âu.',5,502,200)");
//
//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Sữa Biomilk Cho Chó Mèo Còi Cọc, Chậm Lớn 100g – Việt Nam',450000,502000,0.1,'suachocho2','thucanchocho','suachocho','moinhat','thuonghieukhac','- Đối với chó mèo 3 tháng tuổi trở xuống, sữa là một nguồn dinh dưỡng cực kì quan trọng. Đặc biệt là nếu bạn cho thú cưng tách mẹ quá sớm, thì bạn cần bổ sung sữa công thức để giúp cải thiện sức khoẻ của chó mèo.\n" +
//                    "- Sữa Biomilk là một trong những dòng sản phẩm sữa phổ biến và nổi tiếng nhất ở Việt Nam.\n" +
//                    "- Sản phẩm được điều chế dựa với công thức giống nhất với sữa của chó mèo mẹ. Từ đó đảm bảo thú cưng của bạn sẽ có được nguồn dinh dưỡng dồi dào và phù hợp với thể trạng trong giai đoạn này.\n" +
//                    "- Sữa Biomilk được sản xuất 100% tại Việt Nam, tuân thủ theo các tiêu chuẩn sản xuất nghiêm ngặt, do đó hoàn toàn an toàn với thú cưng của bạn.',5,502,200)");
//
//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Cỏ Mèo Khô Dạng Ống Bioline 5g – Giúp Mèo Giảm Stress',75000,80000,0.06,'comeo1','dochoichomeo','comeo','hiem','thuonghieukhac','- Mèo là một trong những loài động vật rất dễ căng thẳng và hoảng sợ vì chúng luôn luôn đề phòng môi trường xung quanh.\n" +
//                    "- Vì vậy khi nuôi mèo bạn cần biết rõ một số phương pháp để giúp giảm căng thẳng và làm cho mèo cảm thấy thoải mái hơn.\n" +
//                    "- Cỏ mèo là một trong những sản phẩm mà bạn nên mua bởi vì chúng không những tốt cho sức khỏe mà còn làm cho mèo cảm thấy dễ chịu hơn.\n" +
//                    "- Cỏ mèo là một loài thực vật có trong tự nhiên, có ảnh hưởng tới hệ thần kinh của mèo.\n" +
//                    "- Cỏ mèo không những giúp cho chúng cảm thấy thư giãn hơn mà còn giúp giãn cơ thể. Từ đó, mèo sẽ có nhiều thời gian cho cơ thể nghỉ ngơi hơn.',5,502,200)");
//
//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Bàn Chải Tắm Massage Cho Chó Mèo 12 8.5cm',75000,80000,0.06,'longmongchomeo2','dodungchomeo','longmongchomeo','hiem','thuonghieukhac','- Sản phẩm giúp việc tắm rửa cho chó mèo trở nên đơn giản và dễ dàng hơn.\n" +
//                    "- Bàn chải được làm từ cao su vì vậy rất mềm mại và không gây đau cho chó mèo.\n" +
//                    "- Khi sử dụng sản phẩm, bạn sẽ dễ dàng massage cho thú cưng cũng như vừa tắm vừa chải lông cho chúng.\n" +
//                    "- Sản phẩm dễ lau chùi và không bám bẩn.\n" +
//                    "- Bàn chải kết hợp tốt nhất với các loại sữa tắm tạo bọt vì sẽ giúp cho chó mèo thấy thoải mái hơn khi tắm.',5,502,200)");
//
//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Kem Đánh Răng Cho Mèo Bioline 50g – Vị Phô Mai – Full Bàn Chải',75000,80000,0.06,'taimatchomeo1','dodungchomeo','taimatchomeo','hiem','thuonghieukhac','- Đánh răng cho mèo là việc vô cùng quan trọng vì nếu không giữ vệ sinh răng cho mèo kỹ lưỡng thì khi về già, răng mèo yếu thì mèo sẽ bỏ ăn nhiều hơn và ảnh hưởng nhiều đến sức khỏe tổng thể của mèo.\n" +
//                    "- Việc đánh răng cho mèo sẽ hơi khó khăn vì mèo thường không để yên cho bạn đụng vào miệng và răng của chúng.\n" +
//                    "- Chính vị vậy, kem đánh răng Bioline có hương vị phô mai giúp cho mèo cảm thấy như kem đánh răng như một loại \"Thức ăn\" có mùi vị ngon và sẽ dễ dàng giúp bạn đánh răng cho bé hơn.\n" +
//                    "- Sản phẩm còn đi kèm với 2 loại bàn chải khác nhau giúp cho việc chải răng cho mèo trở nên đơn giản hơn.',5,502,200)");
//
//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Gel Loại Bỏ Cao Răng Bioline 100g – Hỗ Trợ Răng Nướu',90000,100000,0.1,'taimatchomeo2','dodungchomeo','taimatchomeo','hiem','thuonghieukhac','- Thương hiệu thuộc thành viên của hiệp hội sản xuất đồ dùng cho thú nuôi cảnh Mỹ APPMA (American Pet Products Manufacturers Association).\n" +
//                    "- Được chứng nhận đạt chuẩn NQA (tổ chức chứng nhận hàng đầu thế giới chứng nhận các tiêu chuẩn quốc tế) và FDA (cơ quan quản lý thực phẩm và dược phẩm của Hoa Kỳ), đảm bảo an toàn tuyệt đối.\n" +
//                    "- Sản phẩm sản xuất theo dây chuyền công nghệ tiên tiến của Đức với công thức nước kết hợp cùng Carbopol 940 (CBP940) nhằm tăng độ nhớt, tạo gel, giúp sản phẩm thẩm thấu vào da, khô nhanh và không tạo lớp màng, không gây kích ứng lên nướu của thú cưng.',5,502,200)");
//
//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Dung Dịch Rửa Tai Trị Viêm Trixie 50ml – Khử Mùi Hôi Tai – Đức',90000,95000,0.05,'taimatchocho2','dodungchocho','taimatchocho','banchay','thuonghieukhac','- Thương hiệu có hơn 45 năm kinh nghiệm và là công ty dẫn đầu thị trường châu Âu về đồ dùng cho thú cưng, TRIXIE cung cấp khoảng 6.500 sản phẩm cho thú nuôi cảnh và đạt chuẩn chứng nhận FDA (cơ quan quản lý thực phẩm và dược phẩm Hoa Kỳ) với thị trường tiêu thụ chính tại Bắc Mỹ (40.00%) và Tây Âu (35.00%). Được tin dùng trên toàn cầu, đảm bảo chất lượng an toàn cho thú cưng.\n" +
//                    "- Dung dịch được sản xuất dưới công nghệ nước khử khuẩn ion (Deionized Water) phương pháp chưng cất, trao đổi ion, đây là nước siêu thuần không chứa các tạp chất. Không gây ngộ độc cho thú cưng khi sử dụng.',5,502,200)");
//
//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Nệm Chữ Nhật Cho Chó Mèo 75 90cm – Dưới 40kg – Hàng Xuất Khẩu',175000,20000,0.13,'nemchocho1','chuonglongchocho','nemchocho','hiem','thuonghieukhac','- Màu sắc đa dạng đẹp mắt.\n" +
//                    "- Chất liệu: Lông nhung kết hợp gòn bi 3D cao cấp nên nệm rất êm mịn, êm ái cho thú cưng giấc ngủ thật ngon.\n" +
//                    "- Sản phẩm được may tỉ mỉ nên đảm bảo rất chắc chắn.\n" +
//                    "- Dễ dàng giặt máy hoặc giặt tay. Rất mau khô.',5,802,80)");
//
//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Nệm Chữ Nhật Cho Chó Mèo 75 90cm – Dưới 40kg – Hàng Xuất Khẩu',175000,20000,0.13,'nemchocho1','chuonglongchocho','nemchocho','hiem','thuonghieukhac','- Màu sắc đa dạng đẹp mắt.\n" +
//                    "- Chất liệu: Lông nhung kết hợp gòn bi 3D cao cấp nên nệm rất êm mịn, êm ái cho thú cưng giấc ngủ thật ngon.\n" +
//                    "- Sản phẩm được may tỉ mỉ nên đảm bảo rất chắc chắn.\n" +
//                    "- Dễ dàng giặt máy hoặc giặt tay. Rất mau khô.',5,802,80)");
//
//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Nệm Chữ Nhật Cho Chó Mèo 75 90cm – Dưới 40kg – Hàng Xuất Khẩu',175000,20000,0.13,'nemchocho1','chuonglongchomeo','nemchomeo','hiem','thuonghieukhac','- Màu sắc đa dạng đẹp mắt.\n" +
//                    "- Chất liệu: Lông nhung kết hợp gòn bi 3D cao cấp nên nệm rất êm mịn, êm ái cho thú cưng giấc ngủ thật ngon.\n" +
//                    "- Sản phẩm được may tỉ mỉ nên đảm bảo rất chắc chắn.\n" +
//                    "- Dễ dàng giặt máy hoặc giặt tay. Rất mau khô.',5,802,80)");
//
//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Balo phi hành gia cho thú cưng freeship balo vận chuyển',175000,20000,0.13,'balochocho1','chuonglongchocho','nemchocho','hiem','thuonghieukhac','Màu: Sản phẩm có đủ các màu và kiểu dáng khác nhau, khách vui lòng inbox trước để chọn màu. Nếu không có màu khách chọn hoặc khách không lựa màu cửa hàng xin phép giao màu ngẫu nhiên\n" +
//                    "Chất liệu: Nhựa cao cấp PVC \n" +
//                    "Kích thước: 32*26*44cm\n" +
//                    "Thích hợp với thú cưng dưới 7kg',5,802,80)");
//
//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Lồng hàng không - LỒNG VẬN CHUYỂN CHÓ MÈO HÀNG ĐẸP -4 Size (Màu Ngẫu Nhiên)',175000,20000,0.13,'longvanchuyencho1','chuonglongchocho','longvanchuyenchocho','hiem','thuonghieukhac','Màu: Sản phẩm có đủ các màu và kiểu dáng khác nhau, khách vui lòng inbox trước để chọn màu. Nếu không có màu khách chọn hoặc khách không lựa màu cửa hàng xin phép giao màu ngẫu nhiên\n" +
//                    "Chất liệu: Nhựa cao cấp PVC \n" +
//                    "Kích thước: 32*26*44cm\n" +
//                    "Thích hợp với thú cưng dưới 7kg',5,802,80)");
//
//            execSql(" INSERT INTO "+TBL_NAME+" VALUES(null, 'Lồng hàng không - LỒNG VẬN CHUYỂN CHÓ MÈO HÀNG ĐẸP -4 Size (Màu Ngẫu Nhiên)',175000,20000,0.13,'longvanchuyencho1','chuonglongchomeo','longvanchuyenchomeo','hiem','thuonghieukhac','Màu: Sản phẩm có đủ các màu và kiểu dáng khác nhau, khách vui lòng inbox trước để chọn màu. Nếu không có màu khách chọn hoặc khách không lựa màu cửa hàng xin phép giao màu ngẫu nhiên\n" +
//                    "Chất liệu: Nhựa cao cấp PVC \n" +
//                    "Kích thước: 32*26*44cm\n" +
//                    "Thích hợp với thú cưng dưới 7kg',5,802,80)");

















        }
    }


}
