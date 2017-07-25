package com.dottyvinnie.portmod.lib;

public class Reference 
	{	
		public static final String MOD_ID = "portmod";
		public static final String MOD_NAME = "Port Mod";
		public static final String MOD_VERSION = "1.7.10-0.1";
		public static final String DEPENDENCIES = "required-after:Forge@[10.13.4.1558,);";
        public static final String ITEM_BLOCK_TEXTURE_PATH = MOD_ID + ":";
        public static final String ITEM_BLOCK_TEXTURE_CUSTOM = "minecraft" + ":";


		public static final String CLIENT_PROXY_CLASS = "com.dottyvinnie.portmod.proxies.ClientProxy";
		public static final String SERVER_PROXY_CLASS = "com.dottyvinnie.portmod.proxies.ServerProxy";
		public static final String GUI_FACTORY_CLASS = "com.dottyvinnie.portmod.client.gui.ConfigGUIFactory";
	}
