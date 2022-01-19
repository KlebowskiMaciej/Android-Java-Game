package com.example.gra;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

/**
 * Klasa odpowiedzialna za platformy.
 * Pobiera wymiary i ładuje platformy do tablicy
 * z której są losowo wybierane.
 */
public class platform
{
    //variable
    public int x,y,width,height;
    Bitmap platform1;
    Bitmap[] plat;

    /**
     * * @author Maciej Kłębowski
     * * @version 1.0
     * Konstrutktor klasy
     *
     */
    platform(Resources res)
    {
        plat= new Bitmap[91];
        plat[0] = BitmapFactory.decodeResource(res,R.drawable.a11);
        plat[1] = BitmapFactory.decodeResource(res,R.drawable.a12);
        plat[2] = BitmapFactory.decodeResource(res,R.drawable.a13);
        plat[3] = BitmapFactory.decodeResource(res,R.drawable.a14);
        plat[4] = BitmapFactory.decodeResource(res,R.drawable.a15);
        plat[5] = BitmapFactory.decodeResource(res,R.drawable.a16);
        plat[6] = BitmapFactory.decodeResource(res,R.drawable.a17);
        plat[7] = BitmapFactory.decodeResource(res,R.drawable.a18);
        plat[8] = BitmapFactory.decodeResource(res,R.drawable.a19);
        plat[9] = BitmapFactory.decodeResource(res,R.drawable.a21);
        plat[10] = BitmapFactory.decodeResource(res,R.drawable.a22);
        plat[11] = BitmapFactory.decodeResource(res,R.drawable.a23);
        plat[12] = BitmapFactory.decodeResource(res,R.drawable.a24);
        plat[13] = BitmapFactory.decodeResource(res,R.drawable.a25);
        plat[14] = BitmapFactory.decodeResource(res,R.drawable.a26);
        plat[15] = BitmapFactory.decodeResource(res,R.drawable.a27);
        plat[16] = BitmapFactory.decodeResource(res,R.drawable.a28);
        plat[17] = BitmapFactory.decodeResource(res,R.drawable.a29);
        plat[18] = BitmapFactory.decodeResource(res,R.drawable.a31);
        plat[19] = BitmapFactory.decodeResource(res,R.drawable.a32);
        plat[20] = BitmapFactory.decodeResource(res,R.drawable.a33);
        plat[21] = BitmapFactory.decodeResource(res,R.drawable.a34);
        plat[22] = BitmapFactory.decodeResource(res,R.drawable.a35);
        plat[23] = BitmapFactory.decodeResource(res,R.drawable.a36);
        plat[24] = BitmapFactory.decodeResource(res,R.drawable.a37);
        plat[25] = BitmapFactory.decodeResource(res,R.drawable.a38);
        plat[26] = BitmapFactory.decodeResource(res,R.drawable.a39);
        plat[27] = BitmapFactory.decodeResource(res,R.drawable.a41);
        plat[28] = BitmapFactory.decodeResource(res,R.drawable.a42);
        plat[29] = BitmapFactory.decodeResource(res,R.drawable.a43);
        plat[30] = BitmapFactory.decodeResource(res,R.drawable.a44);
        plat[31] = BitmapFactory.decodeResource(res,R.drawable.a45);
        plat[32] = BitmapFactory.decodeResource(res,R.drawable.a46);
        plat[33] = BitmapFactory.decodeResource(res,R.drawable.a47);
        plat[34] = BitmapFactory.decodeResource(res,R.drawable.a48);
        plat[35] = BitmapFactory.decodeResource(res,R.drawable.a49);
        plat[36] = BitmapFactory.decodeResource(res,R.drawable.a51);
        plat[37] = BitmapFactory.decodeResource(res,R.drawable.a52);
        plat[38] = BitmapFactory.decodeResource(res,R.drawable.a53);
        plat[39] = BitmapFactory.decodeResource(res,R.drawable.a54);
        plat[40] = BitmapFactory.decodeResource(res,R.drawable.a55);
        plat[41] = BitmapFactory.decodeResource(res,R.drawable.a56);
        plat[42] = BitmapFactory.decodeResource(res,R.drawable.a57);
        plat[43] = BitmapFactory.decodeResource(res,R.drawable.a58);
        plat[44] = BitmapFactory.decodeResource(res,R.drawable.a59);
        plat[45] = BitmapFactory.decodeResource(res,R.drawable.a61);
        plat[46] = BitmapFactory.decodeResource(res,R.drawable.a62);
        plat[47] = BitmapFactory.decodeResource(res,R.drawable.a63);
        plat[48] = BitmapFactory.decodeResource(res,R.drawable.a64);
        plat[49] = BitmapFactory.decodeResource(res,R.drawable.a65);
        plat[50] = BitmapFactory.decodeResource(res,R.drawable.a66);
        plat[51] = BitmapFactory.decodeResource(res,R.drawable.a67);
        plat[52] = BitmapFactory.decodeResource(res,R.drawable.a68);
        plat[53] = BitmapFactory.decodeResource(res,R.drawable.a69);
        plat[54] = BitmapFactory.decodeResource(res,R.drawable.a71);
        plat[55] = BitmapFactory.decodeResource(res,R.drawable.a72);
        plat[56] = BitmapFactory.decodeResource(res,R.drawable.a73);
        plat[57] = BitmapFactory.decodeResource(res,R.drawable.a74);
        plat[58] = BitmapFactory.decodeResource(res,R.drawable.a75);
        plat[59] = BitmapFactory.decodeResource(res,R.drawable.a76);
        plat[60] = BitmapFactory.decodeResource(res,R.drawable.a77);
        plat[61] = BitmapFactory.decodeResource(res,R.drawable.a78);
        plat[62] = BitmapFactory.decodeResource(res,R.drawable.a79);
        plat[63] = BitmapFactory.decodeResource(res,R.drawable.a81);
        plat[64] = BitmapFactory.decodeResource(res,R.drawable.a82);
        plat[65] = BitmapFactory.decodeResource(res,R.drawable.a83);
        plat[66] = BitmapFactory.decodeResource(res,R.drawable.a84);
        plat[67] = BitmapFactory.decodeResource(res,R.drawable.a85);
        plat[68] = BitmapFactory.decodeResource(res,R.drawable.a86);
        plat[69] = BitmapFactory.decodeResource(res,R.drawable.a87);
        plat[70] = BitmapFactory.decodeResource(res,R.drawable.a88);
        plat[71] = BitmapFactory.decodeResource(res,R.drawable.a89);
        plat[72] = BitmapFactory.decodeResource(res,R.drawable.a91);
        plat[73] = BitmapFactory.decodeResource(res,R.drawable.a92);
        plat[74] = BitmapFactory.decodeResource(res,R.drawable.a93);
        plat[75] = BitmapFactory.decodeResource(res,R.drawable.a94);
        plat[76] = BitmapFactory.decodeResource(res,R.drawable.a95);
        plat[77] = BitmapFactory.decodeResource(res,R.drawable.a96);
        plat[78] = BitmapFactory.decodeResource(res,R.drawable.a97);
        plat[79] = BitmapFactory.decodeResource(res,R.drawable.a98);
        plat[80] = BitmapFactory.decodeResource(res,R.drawable.a99);
        plat[81] = BitmapFactory.decodeResource(res,R.drawable.a101);
        plat[82] = BitmapFactory.decodeResource(res,R.drawable.a102);
        plat[83] = BitmapFactory.decodeResource(res,R.drawable.a103);
        plat[84] = BitmapFactory.decodeResource(res,R.drawable.a104);
        plat[85] = BitmapFactory.decodeResource(res,R.drawable.a105);
        plat[86] = BitmapFactory.decodeResource(res,R.drawable.a106);
        plat[87] = BitmapFactory.decodeResource(res,R.drawable.a107);
        plat[88] = BitmapFactory.decodeResource(res,R.drawable.a108);
        plat[89] = BitmapFactory.decodeResource(res,R.drawable.a109);
        plat[90] = BitmapFactory.decodeResource(res,R.drawable.a110);

        int i = new Random().nextInt(90);
        width=plat[i].getWidth();
        height=plat[i].getHeight();
        platform1=Bitmap.createScaledBitmap(plat[i],width,height,false);

    }
}
