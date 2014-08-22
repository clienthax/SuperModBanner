package uk.co.haxyshideout.supermodbanner.config;

import net.minecraftforge.common.config.Configuration;
import uk.co.haxyshideout.safeplace.SafePlace;
import uk.co.haxyshideout.supermodbanner.SuperModBanner;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SuperModBannerConfig {

	Configuration config = new Configuration(new File("config/"+ SuperModBanner.MODID+".cfg"));

	private String modLists, whitelist;
	public ArrayList<String> bannedMods = new ArrayList<>();
	public ArrayList<String> whitelistedPlayers = new ArrayList<>();
	public boolean kickForBannedMods;


	public SuperModBannerConfig()
	{
		this.modLists = config.get("BannedMods", "Banned modID Eg:(pokeradar,xray,otherModId) ", "PokeRadar_2_0,schematica").getString();
		this.whitelist = config.get("Whitelist", "Whitelisted players Eg: player1,player2,player3 ", "null").getString();
		this.kickForBannedMods = config.get("General", "Kick people with banned mods ", "true").getBoolean();
		config.save();
		Collections.addAll(bannedMods, modLists.split(","));
		Collections.addAll(whitelistedPlayers, whitelist.split(","));

	}
}
