# BrazaON - V3: O Cinema Brasileiro Completo

A versão **V3** é a mais robusta até agora, trazendo uma separação clara entre **Filmes** e **Séries**, além de organizar o conteúdo em seções temáticas.

## Novas Seções

Tanto para Filmes quanto para Séries, agora temos:
1.  **Top 10**: As produções mais bem avaliadas com um número significativo de votos.
2.  **Premiados**: Destaques da crítica e do público (votos altos e frequentes).
3.  **Recém Adicionados**: Os lançamentos mais recentes no catálogo do TMDb.

## O que mudou?

| Recurso | Descrição |
|---|---|
| **Séries Brasileiras** | Agora o BrazaON também puxa séries produzidas no Brasil (`/tv`). |
| **Menu Categorizado** | Links diretos para Filmes e Séries no menu superior. |
| **Busca Multi-Conteúdo** | A barra de pesquisa agora busca tanto filmes quanto séries simultaneamente. |
| **Páginas de Catálogo** | Templates específicos para navegar por cada categoria de conteúdo. |

## Detalhes Técnicos

- **Modelo Genérico**: O modelo `Movie` foi atualizado para suportar campos de Séries (`name`, `first_air_date`).
- **TmdbService**: Novos métodos para buscar Top 10, Premiados e Recém Adicionados usando filtros avançados de `sort_by` e `vote_count`.
- **Thymeleaf**: Uso de fragmentos e novos templates (`catalogo.html`, `busca.html`) para uma navegação fluida.
