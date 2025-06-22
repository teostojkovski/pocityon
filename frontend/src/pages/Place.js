import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { Typography, Card, CardContent, CardMedia, Button, Grid, CircularProgress, Box, Avatar, List, ListItem, ListItemAvatar, ListItemText, Divider, Paper } from '@mui/material';
import AddCommentIcon from '@mui/icons-material/AddComment';
import axios from 'axios';

function Place() {
  const { placeId } = useParams();
  const [place, setPlace] = useState(null);
  const [images, setImages] = useState([]);
  const [suggestions, setSuggestions] = useState([]);
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();

  useEffect(() => {
    Promise.all([
      axios.get(`http://localhost:8080/api/places/${placeId}`),
      axios.get(`http://localhost:8080/api/images/place/${placeId}`),
      axios.get(`http://localhost:8080/api/suggestions/place/${placeId}`)
    ]).then(([placeRes, imgRes, suggRes]) => {
      setPlace(placeRes.data);
      setImages(imgRes.data);
      setSuggestions(suggRes.data);
      setLoading(false);
    }).catch(() => setLoading(false));
  }, [placeId]);

  if (loading) return <Box sx={{ display: 'flex', justifyContent: 'center', mt: 8 }}><CircularProgress /></Box>;
  if (!place) return <Typography>Place not found.</Typography>;

  return (
    <Box>
      <Paper elevation={3} sx={{ p: 3, mb: 4 }}>
        <Box sx={{ display: 'flex', alignItems: 'center', mb: 2 }}>
          <Avatar sx={{ width: 72, height: 72, mr: 3 }} src={place.logo || undefined}>{place.name[0]}</Avatar>
          <Box>
            <Typography variant="h4">{place.name}</Typography>
            <Typography variant="subtitle1" color="text.secondary">{place.description}</Typography>
            <Typography variant="body2" color="text.secondary">Category: {place.category?.name}</Typography>
          </Box>
        </Box>
        <Grid container spacing={2} sx={{ mb: 2 }}>
          {images.map(img => (
            <Grid item key={img.id}>
              <CardMedia
                component="img"
                height="80"
                image={img.url}
                alt={place.name}
                sx={{ borderRadius: 2, width: 80, objectFit: 'contain', background: '#fff' }}
              />
            </Grid>
          ))}
        </Grid>
        <Typography variant="body1">Contact: {place.contact || place.phone || place.phoneNumber || 'N/A'}</Typography>
        <Typography variant="body1">Website: {place.website || place.websiteUrl ? <a href={place.website || place.websiteUrl} target="_blank" rel="noopener noreferrer">{place.website || place.websiteUrl}</a> : 'N/A'}</Typography>
        <Typography variant="body1">Menu: {place.menu ? <a href={place.menu} target="_blank" rel="noopener noreferrer">View Menu</a> : 'N/A'}</Typography>
        {place.address && <Typography variant="body1">Address: {place.address}</Typography>}
        {(place.latitude !== 0 && place.longitude !== 0) && (
          <Box sx={{ mt: 2 }}>
            <iframe
              title="map"
              width="100%"
              height="200"
              frameBorder="0"
              style={{ border: 0 }}
              src={`https://www.openstreetmap.org/export/embed.html?bbox=${place.longitude - 0.01}%2C${place.latitude - 0.01}%2C${place.longitude + 0.01}%2C${place.latitude + 0.01}&layer=mapnik&marker=${place.latitude}%2C${place.longitude}`}
              allowFullScreen
            />
          </Box>
        )}
      </Paper>
      <Box>
        <Box sx={{ display: 'flex', alignItems: 'center', mb: 1 }}>
          <Typography variant="h5" sx={{ flexGrow: 1 }}>Suggestions</Typography>
          <Button variant="contained" startIcon={<AddCommentIcon />} onClick={() => navigate(`/suggestions?place=${place.id}`)}>
            Add Suggestion
          </Button>
        </Box>
        {suggestions.length === 0 ? (
          <Typography color="text.secondary">No suggestions yet.</Typography>
        ) : (
          <List>
            {suggestions.map(sugg => (
              <React.Fragment key={sugg.id}>
                <ListItem alignItems="flex-start">
                  <ListItemAvatar>
                    <Avatar>{sugg.user?.username ? sugg.user.username[0] : '?'}</Avatar>
                  </ListItemAvatar>
                  <ListItemText
                    primary={sugg.title || sugg.text || 'Suggestion'}
                    secondary={
                      <>
                        <Typography component="span" variant="body2" color="text.primary">
                          {sugg.user?.username || 'Anonymous'}
                        </Typography>
                        {` — ${sugg.content || sugg.text || ''}`}
                      </>
                    }
                  />
                </ListItem>
                <Divider variant="inset" component="li" />
              </React.Fragment>
            ))}
          </List>
        )}
      </Box>
    </Box>
  );
}

export default Place; 