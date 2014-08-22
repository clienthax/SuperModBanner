package uk.co.haxyshideout.supermodbanner;

import com.pixelmonmod.pixelmon.Pixelmon;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import uk.co.haxyshideout.supermodbanner.config.SuperModBannerConfig;
import uk.co.haxyshideout.supermodbanner.events.EventHandler;

@Mod(modid = SuperModBanner.MODID, version = SuperModBanner.VERSION, name = SuperModBanner.NAME, acceptableRemoteVersions = "*",  dependencies = "after:pixelmon")
public class SuperModBanner {

	public static final String MODID = "supermodbanner";
	public static final String NAME = "SuperModBanner";
	public static final String VERSION = "2.0";

	@Mod.Instance(SuperModBanner.MODID)
	public static SuperModBanner instance;

	public static EventHandler eventHandler;
	public static SuperModBannerConfig config;

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		config = new SuperModBannerConfig();
		eventHandler = new EventHandler();
		Pixelmon.EVENT_BUS.register(eventHandler);
		FMLLog.info("initalizating SuperModBanner v" + VERSION + " by Clienthax");
	}

}
