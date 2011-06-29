package org.kirunews.util;

import java.util.Map;
import java.util.TreeMap;

public class Languages {
	private static Map<String, String> languages = new TreeMap<String, String>();
	
	// http://www.loc.gov/standards/iso639-2/php/code_list.php
	static {
		//languages.put("bs", "Bosanski – Bosnian – bosniaque");
		//languages.put("br", "Brezhoneg – Breton – breton");
		languages.put("ca", "Català – Catalan – catalan"); //
		languages.put("cs", "Česky – Czech – tchèque");
		//languages.put("cy", "Cymraeg – Welsh – gallois");
		//languages.put("da", "Dansk – Danish – danois");
		languages.put("de", "Deutsch – German – allemand");
		//languages.put("et", "Eesti – Estonian – estonien");
		languages.put("el", "Ελληνικά – Greek – grec"); 
		languages.put("en", "English – anglais");
		languages.put("es", "Español – Spanish – espagnol");
		//languages.put("eo", "Esperanto – espéranto");
		//languages.put("ext", "Estremeñu – ");
		languages.put("eu", "Euskara – Basque – basque");
		//languages.put("fo", "Føroyskt – Faroese – féroïen");
		languages.put("fr", "Français – French");
		//languages.put("fy", "Frysk – Western Frisian – frison occidental");
		//languages.put("fur", "Furlan – Friulian – frioulan");
		//languages.put("ga", "Gaeilge – Irish – irlandais");
		languages.put("gl", "Galego – Galician – galicien");
		//languages.put("haw", "Hawai`i – Hawaiian – hawaïen");
		languages.put("hr", "Hrvatski – Croatian – croate");
		//languages.put("io", "Ido");
		//languages.put("ilo", "Ilokano – Iloko – ilocano");
		//languages.put("id", "Bahasa Indonesia – Indonesian – indonésien");
		//languages.put("ia", "Interlingua");
		//languages.put("is", "Íslenska – Icelandic – islandais");
		languages.put("it", "Italiano – Italian – italien");
		//languages.put("jv", "Basa Jawa – Javanese – javanais");
		//languages.put("sw", "Kiswahili – Swahili – swahili");
		//languages.put("ku", "Kurdî – Kurdish – kurde");
		languages.put("la", "Latina – Latin");
		//languages.put("lv", "Latviešu – Latvian – letton");
		//languages.put("lb", "Lëtzebuergesch – Luxembourgish – luxembourgeois");
		//languages.put("lt", "Lietuvių – Lithuanian – lituanien");
		//languages.put("lij", "Líguru – ");
		//languages.put("li", "Limburgs – Limburgan – limbourgeois");
		languages.put("hu", "Magyar – Hungarian – hongrois");
		//languages.put("mk", "Македонски – Macedonian – macédonien"); 
		//languages.put("ms", "Bahasa Melayu – Malay – malais");
		//languages.put("mn", "Монгол – Mongolian – mongol");
		//languages.put("nah", "Nāhuatl – Nahuatl languages – nahuatl, langues");
		languages.put("nl", "Nederlands – Dutch; Flemish – néerlandais; flamand");
		//languages.put("no", "Norsk (bokmål) – Norwegian – norvégien");
		//languages.put("nn", "Norsk (nynorsk) – Nynorsk – nynorsk");
		//languages.put("nrm", "Nouormand – ");
		languages.put("oc", "Occita – Occitan");
		//languages.put("uz", "O'zbek – Uzbek – ouszbek");
		//languages.put("pag", "Pangasinan");
		//languages.put("pms", "Piemonteis – ");
		//languages.put("nds", "Plattdüütsch – Low German – bas allemand");
		languages.put("pl", "Polski – Polish – polonais");
		languages.put("pt", "Portugues – Portuguese – portugais");
		//languages.put("kaa", "Qaraqalpaqsha – Kara-Kalpak – karakalpak");
		languages.put("ro", "Română – Romanian – roumain");
		//languages.put("qu", "Runa Simi – Quechua – quechua");
		languages.put("ru", "Русский – Russian – russe");
		//languages.put("se", "Sámegiella – Northern Sami – sami du Nord");
		//languages.put("sco", "Scots – Scots – écossais");
		//languages.put("sq", "Shqip – Albanian – albanais");
		languages.put("scn", "Sicilianu – Sicilian – sicilien");
		languages.put("sk", "Slovenčina – Slovak – slovaque");
		//languages.put("sl", "Slovenščina – Slovenian – slovène");
		//languages.put("szl", "Ślůnski – ");
		//languages.put("sr", "Српски / Srpski – Serbian – serbe");
		//languages.put("sh", "Srpskohrvatski / Српскохрватски – ");
		//languages.put("fi", "Suomi – Finnish – finnois");
		languages.put("sv", "Svenska – Swedish – suédois");
		//languages.put("tl", "Tagalog");
		//languages.put("kab", "Taqbaylit");
		languages.put("tr", "Türkçe – Turkish – turc");
		//languages.put("uk", "Українська – Ukrainian – ukrainien"); 
		//languages.put("vi", "Tiếng Việt – Vietnamese – vietnamien");
		//languages.put("vo", "Volapük");
		//languages.put("fiu-vro", "Võro");
		//languages.put("diq", "Zazaki");
		//languages.put("bat-smg", "Žemaiteška – Baltic languages – baltes, langues");
		//languages.put("zh", "中文 – Chinese – chinois");
	}
	
	public static String getName(String key) {
		if(languages.containsKey(key)) {
			return languages.get(key);
		}
		return "";
	}
	
	public static boolean exists(String key) {
		return languages.containsKey(key);
	}
	
	public static Map<String, String> getLanguages() {
		return languages;
	}

}
