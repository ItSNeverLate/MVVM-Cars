package com.sevenpeakssoftware.mehdi.data.repository

import com.google.gson.Gson
import com.sevenpeakssoftware.mehdi.data.remote.AppService
import com.sevenpeakssoftware.mehdi.data.remote.response.ArticleResponse
import kotlinx.coroutines.delay

class FakeAppService : AppService {
    val gson = Gson()

    override suspend fun getArticles(): ArticleResponse {
        delay(2000)
        return gson.fromJson("{\n" +
                "    \"status\": \"success\",\n" +
                "    \"content\": [\n" +
                "        {\n" +
                "            \"id\": 119302,\n" +
                "            \"title\": \"Q7 - Greatness starts, when you don't stop.\",\n" +
                "            \"dateTime\": \"25.05.2018 14:13\",\n" +
                "            \"tags\": [],\n" +
                "            \"content\": [\n" +
                "                {\n" +
                "                    \"type\": \"text\",\n" +
                "                    \"subject\": \"Q7\",\n" +
                "                    \"description\": \"The Audi Q7 is masculine, yet exudes lightness. Inside, it offers comfort at the highest level. With even more space for your imagination. The 3.0 TDI engine accelerates this powerhouse as a five-seater starting at an impressive 6.3 seconds from 0 to 100 km/h.\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"ingress\": \"The Audi Q7 is the result of an ambitious idea: never cease to improve.\",\n" +
                "            \"image\": \"https://www.apphusetreach.no/sites/default/files/audi_q7.jpg\",\n" +
                "            \"created\": 1511968425,\n" +
                "            \"changed\": 1534311497\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 119300,\n" +
                "            \"title\": \"Q5 - Created for almost any landscape.\",\n" +
                "            \"dateTime\": \"29.11.2017 15:12\",\n" +
                "            \"tags\": [],\n" +
                "            \"content\": [\n" +
                "                {\n" +
                "                    \"type\": \"text\",\n" +
                "                    \"subject\": \"Q5\",\n" +
                "                    \"description\": \"Expressive appearance, powerful drive, and pioneering technology. Your options are just as diverse. Every day anew – with the Audi Q5. Don't leave anything to chance. Whether it comes to comfort, style, or dynamics, the Audi Q5 will win you over from the first moment. \"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"ingress\": \"Don't leave anything to chance. Whether it comes to comfort, style, or dynamics, the Audi Q5 will win you over from the first moment. \",\n" +
                "            \"image\": \"https://www.apphusetreach.no/sites/default/files/audi_q5.jpg\",\n" +
                "            \"created\": 1511968397,\n" +
                "            \"changed\": 1516864387\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 119298,\n" +
                "            \"title\": \"Q2 - En route to myself\",\n" +
                "            \"dateTime\": \"29.11.2017 15:11\",\n" +
                "            \"tags\": [],\n" +
                "            \"content\": [],\n" +
                "            \"ingress\": \"A car that keeps up with your demands – the Audi Q3. Powerful and agile. \",\n" +
                "            \"image\": \"https://www.apphusetreach.no/sites/default/files/audi_q2.jpg\",\n" +
                "            \"created\": 1511968364,\n" +
                "            \"changed\": 1516864403\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 119289,\n" +
                "            \"title\": \"A7 - Four rings. A clear line.\",\n" +
                "            \"dateTime\": \"29.11.2017 15:09\",\n" +
                "            \"tags\": [],\n" +
                "            \"content\": [\n" +
                "                {\n" +
                "                    \"type\": \"text\",\n" +
                "                    \"subject\": \"A7\",\n" +
                "                    \"description\": \"From its sharp lights with distinctive light signature via its upstanding front end with a single wide frame and its coupé-like silhouette to its sculptural rear end, the Audi A7 Sportback is an ambassador of a revolutionary language of design, carrying classic quattro genes at the same time. Proof that one can remain true to oneself through reinvention.\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"ingress\": \"Distinctive, unmistakable, A7. \",\n" +
                "            \"image\": \"https://www.apphusetreach.no/sites/default/files/audi_a7.jpg\",\n" +
                "            \"created\": 1511968219,\n" +
                "            \"changed\": 1516864417\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 119287,\n" +
                "            \"title\": \"A6 - Fascination comes through in many facets.\",\n" +
                "            \"dateTime\": \"29.11.2017 15:08\",\n" +
                "            \"tags\": [],\n" +
                "            \"content\": [\n" +
                "                {\n" +
                "                    \"type\": \"text\",\n" +
                "                    \"subject\": \"A6\",\n" +
                "                    \"description\": \"And a thrilling wide range of equipment. The Audi A6 Saloon and the Audi A6 Avant combine these values within an extraordinary symbiosis of sportiness and elegance, and open a wide range of possibilities for pioneering mobility. Discover yours. Innovative technologies. Progressive design. \"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"ingress\": \"Innovative technologies. Progressive design. And a thrilling wide range of equipment.\",\n" +
                "            \"image\": \"https://www.apphusetreach.no/sites/default/files/audi_a6_0.jpg\",\n" +
                "            \"created\": 1511968178,\n" +
                "            \"changed\": 1516618788\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 119285,\n" +
                "            \"title\": \"A5 - Sets standards.\",\n" +
                "            \"dateTime\": \"08.02.2018 15:08\",\n" +
                "            \"tags\": [],\n" +
                "            \"content\": [\n" +
                "                {\n" +
                "                    \"type\": \"text\",\n" +
                "                    \"subject\": \"A5\",\n" +
                "                    \"description\": \"Technically, the sport coupe is state of the art: In addition to the new body, the Audi A5 impresses with a completely new chassis, high-performance drive technology, innovative infotainment equipment and driver assistance systems. The Audi A5 sets standards. The formative design has been modernised and is more chiselled. The redesigned front with the optional Audi Matrix LED headlights which perform the dynamic functions. \"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"ingress\": \"The Audi A5 sets standards. The formative design has been modernised and is more chiselled. The redesigned front with the optional Audi Matrix LED headlights which perform the dynamic functions.\",\n" +
                "            \"image\": \"https://www.apphusetreach.no/sites/default/files/audi_a5.jpg\",\n" +
                "            \"created\": 1511968135,\n" +
                "            \"changed\": 1534311448\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 119282,\n" +
                "            \"title\": \"A4 - Feel progress.\",\n" +
                "            \"dateTime\": \"01.01.2018 15:07\",\n" +
                "            \"tags\": [],\n" +
                "            \"content\": [\n" +
                "                {\n" +
                "                    \"type\": \"text\",\n" +
                "                    \"subject\": \"A4\",\n" +
                "                    \"description\": \"The Audi A4 allroad quattro – expressiveness that strikes a chord. Wherever the journey takes you. Thanks to quattro all-wheel drive. Plus optional innovative infotainment and assistance systems that ensure a high level of comfort, convenience and safety. Fascinating technology. Design that sets standards. Extravagant. \"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"ingress\": \"Fascinating technology. Design that sets standards. Extravagant. The Audi A4 allroad quattro – expressiveness that strikes a chord. Wherever the journey takes you.\",\n" +
                "            \"image\": \"https://www.apphusetreach.no/sites/default/files/audi_a4.jpg\",\n" +
                "            \"created\": 1511968080,\n" +
                "            \"changed\": 1534311464\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 119279,\n" +
                "            \"title\": \"A1 - A great idea. In compact form.\",\n" +
                "            \"dateTime\": \"29.11.2017 15:06\",\n" +
                "            \"tags\": [],\n" +
                "            \"content\": [\n" +
                "                {\n" +
                "                    \"type\": \"text\",\n" +
                "                    \"subject\": \"A1\",\n" +
                "                    \"description\": \"Also equipped with efficient technologies and modern communication solutions. The Audi A1 and the Audi A1 Sportback – two urban performers that whet your appetite. Because greatness has many facets.\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"ingress\": \"Concentrated expression of a modern attitude to life. Custom options. Convincing performance. Always fascinating. \",\n" +
                "            \"image\": \"https://www.apphusetreach.no/sites/default/files/audi_a1_0.jpg\",\n" +
                "            \"created\": 1511968019,\n" +
                "            \"changed\": 1516864475\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 119276,\n" +
                "            \"title\": \"A3 - There's only one direction. Ahead.\",\n" +
                "            \"dateTime\": \"29.11.2017 15:05\",\n" +
                "            \"tags\": [],\n" +
                "            \"content\": [\n" +
                "                {\n" +
                "                    \"type\": \"text\",\n" +
                "                    \"subject\": \"A3\",\n" +
                "                    \"description\": \"An interior that impressively combines aesthetics with intuitive functionality. Our lead can be discovered in many facets. Progressive design that speaks a unique language. Innovative technologies that emphasize dynamism and efficiency.\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"ingress\": \"Progressive design that speaks a unique language. Innovative technologies that emphasize dynamism and efficiency. \",\n" +
                "            \"image\": \"https://www.apphusetreach.no/sites/default/files/audi_a3.jpg\",\n" +
                "            \"created\": 1511967982,\n" +
                "            \"changed\": 1516864494\n" +
                "        }\n" +
                "    ],\n" +
                "    \"serverTime\": 1626622347\n" +
                "}", ArticleResponse::class.java)
    }

}