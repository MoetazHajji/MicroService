# build stage
FROM mcr.microsoft.com/dotnet/sdk:6.0 AS build
WORKDIR /source
COPY . .

RUN dotnet restore "./MicroStages/MicroStages.csproj" --disable-parallel
RUN dotnet publish "./MicroStages/MicroStages.csproj" -c release -o /app

# Server Stage
FROM mcr.microsoft.com/dotnet/aspnet:6.0 AS final
WORKDIR /app
COPY --from=build /app ./
EXPOSE 5000
ENTRYPOINT ["dotnet", "MicroStages.dll"]

