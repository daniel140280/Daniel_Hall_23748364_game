# Daniel_Hall_23748364_game
Game application for 6G5Z0059 Software Design and Architecture

# Spring Game Board

This is a simple Spring Boot game where players move across a board with numbered and special tiles.

## Features
- Player movement by index
- Special tiles: Home, R1, R2, End
- REST API endpoints (coming soon)

## Design
### Player
- Use of interface - because.....makes design clean, maintainable and extensible.
- **Scalable**: ability to add additional players easily (i.e. GreenPlayer, YellowPlayer).
- **Encapsulated**: each players owns their own board and movement.
- **Flexible**: simple to add and amend win condition, add upgrades or change logic without impacting players.
- **Readable**: clear separation of concerns. Game logic is separate from player logic and state.
- Maintainability

## How to Run
```bash
./mvnw spring-boot:run

