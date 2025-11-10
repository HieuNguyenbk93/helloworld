package com.exam.helloworld.socket.app.test;

import com.tvd12.ezyfoxserver.constant.EzyEventType;
import com.tvd12.ezyfoxserver.constant.EzyMaxRequestPerSecondAction;
import com.tvd12.ezyfoxserver.embedded.EzyEmbeddedServer;
import com.tvd12.ezyfoxserver.ext.EzyAppEntry;
import com.tvd12.ezyfoxserver.ext.EzyPluginEntry;
import com.tvd12.ezyfoxserver.setting.*;
import com.exam.helloworld.socket.app.AppEntryLoader;
import com.exam.helloworld.socket.plugin.PluginEntryLoader;

public class HelloworldSocketAppStartupTest {

    private static final String APP_NAME = "helloworld";
    private static final String PLUGIN_NAME = "helloworld";
    private static final String ZONE_NAME = "helloworld";

    public static void main(String[] args) throws Exception {

        EzyPluginSettingBuilder pluginSettingBuilder = new EzyPluginSettingBuilder()
            .name(PLUGIN_NAME)
            .addListenEvent(EzyEventType.USER_LOGIN)
            .entryLoader(DecoratedPluginEntryLoader.class);

        EzyAppSettingBuilder appSettingBuilder = new EzyAppSettingBuilder()
            .name(APP_NAME)
            .entryLoader(DecoratedAppEntryLoader.class);

        EzyUserManagementSettingBuilder userManagementSettingBuilder = new EzyUserManagementSettingBuilder()
            .allowChangeSession(true)
            .allowGuestLogin(true)
            .guestNamePrefix("Guest#")
            .maxSessionPerUser(1)
            .userMaxIdleTimeInSecond(15)
            .userNamePattern("^[a-z0-9_.]{3,36}$");

        EzyZoneSettingBuilder zoneSettingBuilder = new EzyZoneSettingBuilder()
            .name(ZONE_NAME)
            .userManagement(userManagementSettingBuilder.build())
            .application(appSettingBuilder.build())
            .plugin(pluginSettingBuilder.build());

        EzySocketSettingBuilder socketSettingBuilder = new EzySocketSettingBuilder()
            .sslActive(true);

        EzyUdpSettingBuilder udpSettingBuilder = new EzyUdpSettingBuilder()
            .active(true);

        EzySessionManagementSettingBuilder sessionManagementSettingBuilder =
            new EzySessionManagementSettingBuilder()
                .sessionMaxRequestPerSecond(
                    new EzySessionManagementSettingBuilder.EzyMaxRequestPerSecondBuilder()
                        .value(60)
                        .action(EzyMaxRequestPerSecondAction.DISCONNECT_SESSION)
                        .build()
                );

        EzySimpleSettings settings = new EzySettingsBuilder()
            .socket(socketSettingBuilder.build())
            .udp(udpSettingBuilder.build())
            .zone(zoneSettingBuilder.build())
            .sessionManagement(sessionManagementSettingBuilder.build())
            .build();

        EzyEmbeddedServer server = EzyEmbeddedServer.builder()
            .settings(settings)
            .build();
        server.start();
    }

    public static class DecoratedPluginEntryLoader extends PluginEntryLoader {

        @Override
        public EzyPluginEntry load() {
            return new PluginEntry() {
                @Override
                protected String[] getScanablePackages() {
                    return new String[] { "com.exam.helloworld" };
                }
            };
        }
    }

    public static class DecoratedAppEntryLoader extends AppEntryLoader {

        @Override
        public EzyAppEntry load() {
            return new AppEntry() {
                @Override
                protected String[] getScanablePackages() {
                    return new String[] { "com.exam.helloworld" };
                }
            };
        }
    }
}
