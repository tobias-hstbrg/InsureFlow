# Cleanup-Script für Nexus Customer Service
$rootPath = "E:\NEXUS\CUSTOMER-SERVICE"
Set-Location $rootPath

Write-Host "--- Starte Projekt-Bereinigung ---" -ForegroundColor Cyan

# 1. Redundante .idea Verzeichnisse löschen (außer im Root)
Write-Host "> Lösche redundante .idea Ordner..."
Get-ChildItem -Path . -Include .idea -Recurse -Directory | Where-Object { $_.FullName -ne "$rootPath\.idea" } | Remove-Item -Recurse -Force -ErrorAction SilentlyContinue

# 2. Alle .iml Dateien löschen
Write-Host "> Lösche .iml Dateien..."
Get-ChildItem -Path . -Include *.iml -Recurse | Remove-Item -Force

# 3. Alle .gitignore Dateien löschen (wir erstellen gleich eine neue im Root)
Write-Host "> Entferne alte .gitignore Dateien..."
Get-ChildItem -Path . -Include .gitignore -Recurse | Remove-Item -Force

# 4. Den falsch platzierten 'out' Ordner im Source-Verzeichnis löschen
Write-Host "> Lösche Fehlplatzierte Build-Outputs (out/target)..."
$outDir = Join-Path $rootPath "customer-service\src\main\java\de\insureflow\out"
if (Test-Path $outDir) { Remove-Item -Recurse -Force $outDir }

# 5. Neue zentrale .gitignore im Root erstellen
Write-Host "> Erstelle neue Master-.gitignore..."
$gitignoreContent = @"
# IntelliJ IDEA
.idea/
*.iml
*.iws
*.ipr
out/

# Maven
target/
pom.xml.tag
pom.xml.releaseBackup
pom.xml.versionsBackup
pom.xml.next
release.properties
dependency-reduced-pom.xml
buildNumber.properties
.mvn/timing.properties
.mvn/wrapper/maven-wrapper.jar

# Compiled Java classes
*.class

# Log files
*.log

# OS Dateien
.DS_Store
Thumbs.db
"@
$gitignoreContent | Out-File -FilePath ".gitignore" -Encoding utf8

# 6. Git Index bereinigen (nur wenn es ein Git-Repo ist)
if (Test-Path ".git") {
    Write-Host "> Bereinige Git-Index..." -ForegroundColor Yellow
    git rm -r --cached .
    git add .
    Write-Host "FERTIG: Der Git-Index wurde zurückgesetzt. Du musst jetzt nur noch committen." -ForegroundColor Green
} else {
    Write-Host "HINWEIS: Kein .git Ordner gefunden. Die Dateien wurden nur lokal bereinigt." -ForegroundColor Magenta
}

Write-Host "--- Bereinigung abgeschlossen! ---" -ForegroundColor Cyan