import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.elasticsearch.action.TransportActions.Admin.Cluster;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.client.action.index.IndexRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.metadata.MetaDataCreateIndexService.Request;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;

import static org.elasticsearch.node.NodeBuilder.*;
import static org.elasticsearch.common.xcontent.XContentFactory.*;

public class testElastS {

	public static void main(String[] args) throws IOException {

		Node node = nodeBuilder().clusterName("ahmet").node();
		Client client = node.client();
		

		// on shutdown

		
		
		
		Settings settings = ImmutableSettings.settingsBuilder()
				.put("cluster.name", "ahmet")
				.put("client.transport.sniff", true).build();

		TransportClient tranClient = new TransportClient(settings);

		try {

			tranClient = tranClient
					.addTransportAddress(new InetSocketTransportAddress(
							"localhost", 9200));

		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e);

		}

		System.out.print("a");
		
		
		
		CreateIndexRequestBuilder createIndexRequestBuilder = tranClient.admin().indices().prepareCreate("Test");
		createIndexRequestBuilder.execute().actionGet();

		IndexRequestBuilder indexRequestBuilder = node.client().prepareIndex("Test", "Message");

		BufferedReader reader = new BufferedReader(new FileReader(
				"/User/mac/Desktop/test.txt"));
		String line = " ";
		StringBuffer str = new StringBuffer();

		while ((line = reader.readLine()) != null) {

			str.append(line + "\n");

			IndexResponse response = tranClient
					.prepareIndex("ahmet", "den", "1")

					.setSource(jsonBuilder()

					.startObject()

					.field("message", line)

					.endObject()).execute()

					.actionGet();

		}

		tranClient.close();
		reader.close();
		node.close();
		

	}
}
