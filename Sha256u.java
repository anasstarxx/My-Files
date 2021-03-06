public class Sha256u
{
	public static final int SHA256_DIGEST_SIZE=32;
	private int state[]=new int[]{0x6a09e667,0xbb67ae85,0x3c6ef372,0xa54ff53a
		,0x510e527f,0x9b05688c,0x1f83d9ab,0x5be0cd19};
	private long count=0;
	private byte buffer[]=new byte[64];
	private static final int[] K={
		0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5,
		0x3956c25b, 0x59f111f1, 0x923f82a4, 0xab1c5ed5,
		0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3,
		0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174,
		0xe49b69c1, 0xefbe4786, 0x0fc19dc6, 0x240ca1cc,
		0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da,
		0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7,
		0xc6e00bf3, 0xd5a79147, 0x06ca6351, 0x14292967,
		0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13,
		0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85,
		0xa2bfe8a1, 0xa81a664b, 0xc24b8b70, 0xc76c51a3,
		0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070,
		0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5,
		0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3,
		0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208,
		0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2
	};
	private void WriteByteBlock(){
		int W[]=new int[16],j;
		for (j = 0; j < 64; j +=4)W[j/4]=(0xff&buffer[j+3])|((0xff&buffer[j+2])<<8)|((0xff&buffer[j+1])<<16)|(buffer[j]<<24);
		int a=state[0],b=state[1],c=state[2],d=state[3],e=state[4],f=state[5],g=state[6],h=state[7];
		h += (((e>>>6)|(e<<26))^((e>>>11)|(e<<21))^((e>>>25)|(e<<7))) +(g^(e&(f^g))) + K[ 0] + (W[ 0]);d += h; h += (((a>>>2)|(a<<30))^((a>>>13)|(a<<19))^((a>>>22)|(a<<10)))+((a&b)|(c&(a|b)));
		g += (((d>>>6)|(d<<26))^((d>>>11)|(d<<21))^((d>>>25)|(d<<7))) +(f^(d&(e^f))) + K[ 1] + (W[ 1]);c += g; g += (((h>>>2)|(h<<30))^((h>>>13)|(h<<19))^((h>>>22)|(h<<10)))+((h&a)|(b&(h|a)));
		f += (((c>>>6)|(c<<26))^((c>>>11)|(c<<21))^((c>>>25)|(c<<7))) +(e^(c&(d^e))) + K[ 2] + (W[ 2]);b += f; f += (((g>>>2)|(g<<30))^((g>>>13)|(g<<19))^((g>>>22)|(g<<10)))+((g&h)|(a&(g|h)));
		e += (((b>>>6)|(b<<26))^((b>>>11)|(b<<21))^((b>>>25)|(b<<7))) +(d^(b&(c^d))) + K[ 3] + (W[ 3]);a += e; e += (((f>>>2)|(f<<30))^((f>>>13)|(f<<19))^((f>>>22)|(f<<10)))+((f&g)|(h&(f|g)));
		d += (((a>>>6)|(a<<26))^((a>>>11)|(a<<21))^((a>>>25)|(a<<7))) +(c^(a&(b^c))) + K[ 4] + (W[ 4]);h += d; d += (((e>>>2)|(e<<30))^((e>>>13)|(e<<19))^((e>>>22)|(e<<10)))+((e&f)|(g&(e|f)));
		c += (((h>>>6)|(h<<26))^((h>>>11)|(h<<21))^((h>>>25)|(h<<7))) +(b^(h&(a^b))) + K[ 5] + (W[ 5]);g += c; c += (((d>>>2)|(d<<30))^((d>>>13)|(d<<19))^((d>>>22)|(d<<10)))+((d&e)|(f&(d|e)));
		b += (((g>>>6)|(g<<26))^((g>>>11)|(g<<21))^((g>>>25)|(g<<7))) +(a^(g&(h^a))) + K[ 6] + (W[ 6]);f += b; b += (((c>>>2)|(c<<30))^((c>>>13)|(c<<19))^((c>>>22)|(c<<10)))+((c&d)|(e&(c|d)));
		a += (((f>>>6)|(f<<26))^((f>>>11)|(f<<21))^((f>>>25)|(f<<7))) +(h^(f&(g^h))) + K[ 7] + (W[ 7]);e += a; a += (((b>>>2)|(b<<30))^((b>>>13)|(b<<19))^((b>>>22)|(b<<10)))+((b&c)|(d&(b|c)));
		h += (((e>>>6)|(e<<26))^((e>>>11)|(e<<21))^((e>>>25)|(e<<7))) +(g^(e&(f^g))) + K[ 8] + (W[ 8]);d += h; h += (((a>>>2)|(a<<30))^((a>>>13)|(a<<19))^((a>>>22)|(a<<10)))+((a&b)|(c&(a|b)));
		g += (((d>>>6)|(d<<26))^((d>>>11)|(d<<21))^((d>>>25)|(d<<7))) +(f^(d&(e^f))) + K[ 9] + (W[ 9]);c += g; g += (((h>>>2)|(h<<30))^((h>>>13)|(h<<19))^((h>>>22)|(h<<10)))+((h&a)|(b&(h|a)));
		f += (((c>>>6)|(c<<26))^((c>>>11)|(c<<21))^((c>>>25)|(c<<7))) +(e^(c&(d^e))) + K[10] + (W[10]);b += f; f += (((g>>>2)|(g<<30))^((g>>>13)|(g<<19))^((g>>>22)|(g<<10)))+((g&h)|(a&(g|h)));
		e += (((b>>>6)|(b<<26))^((b>>>11)|(b<<21))^((b>>>25)|(b<<7))) +(d^(b&(c^d))) + K[11] + (W[11]);a += e; e += (((f>>>2)|(f<<30))^((f>>>13)|(f<<19))^((f>>>22)|(f<<10)))+((f&g)|(h&(f|g)));
		d += (((a>>>6)|(a<<26))^((a>>>11)|(a<<21))^((a>>>25)|(a<<7))) +(c^(a&(b^c))) + K[12] + (W[12]);h += d; d += (((e>>>2)|(e<<30))^((e>>>13)|(e<<19))^((e>>>22)|(e<<10)))+((e&f)|(g&(e|f)));
		c += (((h>>>6)|(h<<26))^((h>>>11)|(h<<21))^((h>>>25)|(h<<7))) +(b^(h&(a^b))) + K[13] + (W[13]);g += c; c += (((d>>>2)|(d<<30))^((d>>>13)|(d<<19))^((d>>>22)|(d<<10)))+((d&e)|(f&(d|e)));
		b += (((g>>>6)|(g<<26))^((g>>>11)|(g<<21))^((g>>>25)|(g<<7))) +(a^(g&(h^a))) + K[14] + (W[14]);f += b; b += (((c>>>2)|(c<<30))^((c>>>13)|(c<<19))^((c>>>22)|(c<<10)))+((c&d)|(e&(c|d)));
		a += (((f>>>6)|(f<<26))^((f>>>11)|(f<<21))^((f>>>25)|(f<<7))) +(h^(f&(g^h))) + K[15] + (W[15]);e += a; a += (((b>>>2)|(b<<30))^((b>>>13)|(b<<19))^((b>>>22)|(b<<10)))+((b&c)|(d&(b|c)));
		for (j = 16; j < 64;){
			h += (((e>>>6)|(e<<26))^((e>>>11)|(e<<21))^((e>>>25)|(e<<7))) +(g^(e&(f^g))) + K[j++] + ((W[ 0] += (((W[14]>>>17)|(W[14]<<15)) ^ ((W[14]>>>19)|(W[14]<<13)) ^ (W[14] >>> 10)) + W[ 9] + (((W[ 1]>>> 7)|(W[ 1]<<25)) ^ ((W[ 1]>>>18)|(W[ 1]<<14)) ^ (W[ 1] >>> 3))));d += h; h += (((a>>>2)|(a<<30))^((a>>>13)|(a<<19))^((a>>>22)|(a<<10)))+((a&b)|(c&(a|b)));
			g += (((d>>>6)|(d<<26))^((d>>>11)|(d<<21))^((d>>>25)|(d<<7))) +(f^(d&(e^f))) + K[j++] + ((W[ 1] += (((W[15]>>>17)|(W[15]<<15)) ^ ((W[15]>>>19)|(W[15]<<13)) ^ (W[15] >>> 10)) + W[10] + (((W[ 2]>>> 7)|(W[ 2]<<25)) ^ ((W[ 2]>>>18)|(W[ 2]<<14)) ^ (W[ 2] >>> 3))));c += g; g += (((h>>>2)|(h<<30))^((h>>>13)|(h<<19))^((h>>>22)|(h<<10)))+((h&a)|(b&(h|a)));
			f += (((c>>>6)|(c<<26))^((c>>>11)|(c<<21))^((c>>>25)|(c<<7))) +(e^(c&(d^e))) + K[j++] + ((W[ 2] += (((W[ 0]>>>17)|(W[ 0]<<15)) ^ ((W[ 0]>>>19)|(W[ 0]<<13)) ^ (W[ 0] >>> 10)) + W[11] + (((W[ 3]>>> 7)|(W[ 3]<<25)) ^ ((W[ 3]>>>18)|(W[ 3]<<14)) ^ (W[ 3] >>> 3))));b += f; f += (((g>>>2)|(g<<30))^((g>>>13)|(g<<19))^((g>>>22)|(g<<10)))+((g&h)|(a&(g|h)));
			e += (((b>>>6)|(b<<26))^((b>>>11)|(b<<21))^((b>>>25)|(b<<7))) +(d^(b&(c^d))) + K[j++] + ((W[ 3] += (((W[ 1]>>>17)|(W[ 1]<<15)) ^ ((W[ 1]>>>19)|(W[ 1]<<13)) ^ (W[ 1] >>> 10)) + W[12] + (((W[ 4]>>> 7)|(W[ 4]<<25)) ^ ((W[ 4]>>>18)|(W[ 4]<<14)) ^ (W[ 4] >>> 3))));a += e; e += (((f>>>2)|(f<<30))^((f>>>13)|(f<<19))^((f>>>22)|(f<<10)))+((f&g)|(h&(f|g)));
			d += (((a>>>6)|(a<<26))^((a>>>11)|(a<<21))^((a>>>25)|(a<<7))) +(c^(a&(b^c))) + K[j++] + ((W[ 4] += (((W[ 2]>>>17)|(W[ 2]<<15)) ^ ((W[ 2]>>>19)|(W[ 2]<<13)) ^ (W[ 2] >>> 10)) + W[13] + (((W[ 5]>>> 7)|(W[ 5]<<25)) ^ ((W[ 5]>>>18)|(W[ 5]<<14)) ^ (W[ 5] >>> 3))));h += d; d += (((e>>>2)|(e<<30))^((e>>>13)|(e<<19))^((e>>>22)|(e<<10)))+((e&f)|(g&(e|f)));
			c += (((h>>>6)|(h<<26))^((h>>>11)|(h<<21))^((h>>>25)|(h<<7))) +(b^(h&(a^b))) + K[j++] + ((W[ 5] += (((W[ 3]>>>17)|(W[ 3]<<15)) ^ ((W[ 3]>>>19)|(W[ 3]<<13)) ^ (W[ 3] >>> 10)) + W[14] + (((W[ 6]>>> 7)|(W[ 6]<<25)) ^ ((W[ 6]>>>18)|(W[ 6]<<14)) ^ (W[ 6] >>> 3))));g += c; c += (((d>>>2)|(d<<30))^((d>>>13)|(d<<19))^((d>>>22)|(d<<10)))+((d&e)|(f&(d|e)));
			b += (((g>>>6)|(g<<26))^((g>>>11)|(g<<21))^((g>>>25)|(g<<7))) +(a^(g&(h^a))) + K[j++] + ((W[ 6] += (((W[ 4]>>>17)|(W[ 4]<<15)) ^ ((W[ 4]>>>19)|(W[ 4]<<13)) ^ (W[ 4] >>> 10)) + W[15] + (((W[ 7]>>> 7)|(W[ 7]<<25)) ^ ((W[ 7]>>>18)|(W[ 7]<<14)) ^ (W[ 7] >>> 3))));f += b; b += (((c>>>2)|(c<<30))^((c>>>13)|(c<<19))^((c>>>22)|(c<<10)))+((c&d)|(e&(c|d)));
			a += (((f>>>6)|(f<<26))^((f>>>11)|(f<<21))^((f>>>25)|(f<<7))) +(h^(f&(g^h))) + K[j++] + ((W[ 7] += (((W[ 5]>>>17)|(W[ 5]<<15)) ^ ((W[ 5]>>>19)|(W[ 5]<<13)) ^ (W[ 5] >>> 10)) + W[ 0] + (((W[ 8]>>> 7)|(W[ 8]<<25)) ^ ((W[ 8]>>>18)|(W[ 8]<<14)) ^ (W[ 8] >>> 3))));e += a; a += (((b>>>2)|(b<<30))^((b>>>13)|(b<<19))^((b>>>22)|(b<<10)))+((b&c)|(d&(b|c)));
			h += (((e>>>6)|(e<<26))^((e>>>11)|(e<<21))^((e>>>25)|(e<<7))) +(g^(e&(f^g))) + K[j++] + ((W[ 8] += (((W[ 6]>>>17)|(W[ 6]<<15)) ^ ((W[ 6]>>>19)|(W[ 6]<<13)) ^ (W[ 6] >>> 10)) + W[ 1] + (((W[ 9]>>> 7)|(W[ 9]<<25)) ^ ((W[ 9]>>>18)|(W[ 9]<<14)) ^ (W[ 9] >>> 3))));d += h; h += (((a>>>2)|(a<<30))^((a>>>13)|(a<<19))^((a>>>22)|(a<<10)))+((a&b)|(c&(a|b)));
			g += (((d>>>6)|(d<<26))^((d>>>11)|(d<<21))^((d>>>25)|(d<<7))) +(f^(d&(e^f))) + K[j++] + ((W[ 9] += (((W[ 7]>>>17)|(W[ 7]<<15)) ^ ((W[ 7]>>>19)|(W[ 7]<<13)) ^ (W[ 7] >>> 10)) + W[ 2] + (((W[10]>>> 7)|(W[10]<<25)) ^ ((W[10]>>>18)|(W[10]<<14)) ^ (W[10] >>> 3))));c += g; g += (((h>>>2)|(h<<30))^((h>>>13)|(h<<19))^((h>>>22)|(h<<10)))+((h&a)|(b&(h|a)));
			f += (((c>>>6)|(c<<26))^((c>>>11)|(c<<21))^((c>>>25)|(c<<7))) +(e^(c&(d^e))) + K[j++] + ((W[10] += (((W[ 8]>>>17)|(W[ 8]<<15)) ^ ((W[ 8]>>>19)|(W[ 8]<<13)) ^ (W[ 8] >>> 10)) + W[ 3] + (((W[11]>>> 7)|(W[11]<<25)) ^ ((W[11]>>>18)|(W[11]<<14)) ^ (W[11] >>> 3))));b += f; f += (((g>>>2)|(g<<30))^((g>>>13)|(g<<19))^((g>>>22)|(g<<10)))+((g&h)|(a&(g|h)));
			e += (((b>>>6)|(b<<26))^((b>>>11)|(b<<21))^((b>>>25)|(b<<7))) +(d^(b&(c^d))) + K[j++] + ((W[11] += (((W[ 9]>>>17)|(W[ 9]<<15)) ^ ((W[ 9]>>>19)|(W[ 9]<<13)) ^ (W[ 9] >>> 10)) + W[ 4] + (((W[12]>>> 7)|(W[12]<<25)) ^ ((W[12]>>>18)|(W[12]<<14)) ^ (W[12] >>> 3))));a += e; e += (((f>>>2)|(f<<30))^((f>>>13)|(f<<19))^((f>>>22)|(f<<10)))+((f&g)|(h&(f|g)));
			d += (((a>>>6)|(a<<26))^((a>>>11)|(a<<21))^((a>>>25)|(a<<7))) +(c^(a&(b^c))) + K[j++] + ((W[12] += (((W[10]>>>17)|(W[10]<<15)) ^ ((W[10]>>>19)|(W[10]<<13)) ^ (W[10] >>> 10)) + W[ 5] + (((W[13]>>> 7)|(W[13]<<25)) ^ ((W[13]>>>18)|(W[13]<<14)) ^ (W[13] >>> 3))));h += d; d += (((e>>>2)|(e<<30))^((e>>>13)|(e<<19))^((e>>>22)|(e<<10)))+((e&f)|(g&(e|f)));
			c += (((h>>>6)|(h<<26))^((h>>>11)|(h<<21))^((h>>>25)|(h<<7))) +(b^(h&(a^b))) + K[j++] + ((W[13] += (((W[11]>>>17)|(W[11]<<15)) ^ ((W[11]>>>19)|(W[11]<<13)) ^ (W[11] >>> 10)) + W[ 6] + (((W[14]>>> 7)|(W[14]<<25)) ^ ((W[14]>>>18)|(W[14]<<14)) ^ (W[14] >>> 3))));g += c; c += (((d>>>2)|(d<<30))^((d>>>13)|(d<<19))^((d>>>22)|(d<<10)))+((d&e)|(f&(d|e)));
			b += (((g>>>6)|(g<<26))^((g>>>11)|(g<<21))^((g>>>25)|(g<<7))) +(a^(g&(h^a))) + K[j++] + ((W[14] += (((W[12]>>>17)|(W[12]<<15)) ^ ((W[12]>>>19)|(W[12]<<13)) ^ (W[12] >>> 10)) + W[ 7] + (((W[15]>>> 7)|(W[15]<<25)) ^ ((W[15]>>>18)|(W[15]<<14)) ^ (W[15] >>> 3))));f += b; b += (((c>>>2)|(c<<30))^((c>>>13)|(c<<19))^((c>>>22)|(c<<10)))+((c&d)|(e&(c|d)));
			a += (((f>>>6)|(f<<26))^((f>>>11)|(f<<21))^((f>>>25)|(f<<7))) +(h^(f&(g^h))) + K[j++] + ((W[15] += (((W[13]>>>17)|(W[13]<<15)) ^ ((W[13]>>>19)|(W[13]<<13)) ^ (W[13] >>> 10)) + W[ 8] + (((W[ 0]>>> 7)|(W[ 0]<<25)) ^ ((W[ 0]>>>18)|(W[ 0]<<14)) ^ (W[ 0] >>> 3))));e += a; a += (((b>>>2)|(b<<30))^((b>>>13)|(b<<19))^((b>>>22)|(b<<10)))+((b&c)|(d&(b|c)));
		}
		state[0] += a;
		state[1] += b;
		state[2] += c;
		state[3] += d;
		state[4] += e;
		state[5] += f;
		state[6] += g;
		state[7] += h;
	}
	public void Update(byte[] data, long size){
		if (size == 0)return;
		int pos = (int)count & 0x3F;
		count += size;
		int dd = 64 - pos,t;
		if (dd > size){
			for (t=0;t<size;t++)buffer[pos+t]=data[t];
			return;
		}
		size -= dd;
		for (t=0;t<dd;t++)buffer[pos+t]=data[t];
		for (;;){
			WriteByteBlock();
			if (size < 64){
				if (size != 0)for (t=0;t<size;t++)buffer[t]=data[dd+t];
				return;
			}
			size -= 64;
			for ( t=0;t<64;t++)buffer[t]=data[dd++];
		}
	}
	public byte[] Final(){
		int pos = (int)count & 0x3F,i;
		buffer[pos++] =(byte) 0x80;
		while (pos!=56){
			if (pos == 0x40){
				WriteByteBlock();pos=0;
			}else buffer[pos++] = 0;
		}
		//  -- -- --
		//pos=(int)(count>>>29);buffer[56]=(byte)(pos>>>24);buffer[57]=(byte)(pos>>>16);buffer[58]=(byte)(pos>>>8);buffer[59]=(byte)pos;
		//pos=(int)(count<<3);buffer[60]=(byte)(pos>>>24);buffer[61]=(byte)(pos>>>16);buffer[62]=(byte)(pos>>>8);buffer[63]=(byte)(pos);
		//  -- OR --
		buffer[56]=(byte)(count>>>53);buffer[57]=(byte)(count>>>45);buffer[58]=(byte)(count>>>37);buffer[59]=(byte)(count>>>29);
		buffer[60]=(byte)(count>>>21);buffer[61]=(byte)(count>>>13);buffer[62]=(byte)(count>>>5);buffer[63]=(byte)(count<<3);
		//  -- -- --
		WriteByteBlock();
		byte[] digest=new byte[]{
			(byte)(state[0]>>>24),(byte)(state[0]>>>16),(byte)(state[0]>>>8),(byte)state[0],
			(byte)(state[1]>>>24),(byte)(state[1]>>>16),(byte)(state[1]>>>8),(byte)state[1],
			(byte)(state[2]>>>24),(byte)(state[2]>>>16),(byte)(state[2]>>>8),(byte)state[2],
			(byte)(state[3]>>>24),(byte)(state[3]>>>16),(byte)(state[3]>>>8),(byte)state[3],
			(byte)(state[4]>>>24),(byte)(state[4]>>>16),(byte)(state[4]>>>8),(byte)state[4],
			(byte)(state[5]>>>24),(byte)(state[5]>>>16),(byte)(state[5]>>>8),(byte)state[5],
			(byte)(state[6]>>>24),(byte)(state[6]>>>16),(byte)(state[6]>>>8),(byte)state[6],
			(byte)(state[7]>>>24),(byte)(state[7]>>>16),(byte)(state[7]>>>8),(byte)state[7]
		};
		state = new int[]{0x6a09e667,0xbb67ae85,0x3c6ef372,0xa54ff53a
			,0x510e527f,0x9b05688c,0x1f83d9ab,0x5be0cd19};count=0;
		return digest;
	}
}
