package protocolsupport.protocol.transformer.middlepacketimpl.v1_5_1_6_1_7.clientbound.play;

import java.util.Collection;
import java.util.Collections;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.ClientBoundPacket;
import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.clientbound.play.MiddleSpawnPainting;
import protocolsupport.protocol.transformer.middlepacketimpl.PacketData;

public class SpawnPainting extends MiddleSpawnPainting<Collection<PacketData>> {

	@Override
	public Collection<PacketData> toData(ProtocolVersion version) {
		int x = position.getX();
		int z = position.getZ();
		switch (direction) {
			case 0: {
				--z;
				break;
			}
			case 1: {
				++x;
				break;
			}
			case 2: {
				++z;
				break;
			}
			case 3: {
				--x;
				break;
			}
		}
		PacketDataSerializer serializer = PacketDataSerializer.createNew(version);
		serializer.writeInt(entityId);
		serializer.writeString(type);
		serializer.writeInt(x);
		serializer.writeInt(position.getY());
		serializer.writeInt(z);
		serializer.writeInt(direction);
		return Collections.singletonList(new PacketData(ClientBoundPacket.PLAY_SPAWN_PAINTING_ID, serializer));
	}

}